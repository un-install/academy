package hw08;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {
    static SynchronyzedList<Person> persons = new SynchronyzedList<>();
    static BlockingQueue<Person> prsns = new ArrayBlockingQueue<Person>(200);
    static int numberOfThreads = 6;

    public static void main(String[] args) {
        try {
            Thread[] thrds = new Thread[numberOfThreads];
            Runnable run = () -> fillPersons(2000003, numberOfThreads);


            startRunable(run, thrds);
            waitWhileRunning();

            System.out.println(persons.stream().count());

            //to compare time with multithreading
            fillPersons(2000003, 1);

            PersonProducer producer = new PersonProducer(prsns);
            PersonConsumer consumer = new PersonConsumer(prsns);

            new Thread(producer).run();
            new Thread(consumer).run();

            waitWhileRunning();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void startRunable(Runnable run, Thread[] threads) {
        for (Thread t : threads) {
            t = new Thread(run);
            t.start();
        }
    }

    private static void waitWhileRunning() throws InterruptedException {
        //AllStackTraces.size() should return number of running threads
        //But when all near described threads are waiting it returns 6
        while (Thread.getAllStackTraces().keySet().size() > 6) {
            TimeUnit.MILLISECONDS.sleep(10);
        }
    }

    private static void fillPersons(int amount, int amountOfThreads) {
        String[] names = new String[]{"Fill", "Alfred", "Jhon", "Michel", "Mario"};
        String[] works = new String[]{"Google", "Facebook", "HP", "Cisco", "Oracle"};

        int range = amount / amountOfThreads;
        if (Thread.currentThread().getName().equals("Thread-0")) {
            range += amount % amountOfThreads;
        }

        for (int i = 0; i < range; i++) {
            persons.add(new Person(names[(int) (Math.random() * 4 + 1)], (int) (Math.random() * 30 + 18), works[(int) (Math.random() * 4 + 1)]));
        }

        //output finish time
        System.out.println("Time of fillPersons() finish" + new Date().getTime());
    }
}
