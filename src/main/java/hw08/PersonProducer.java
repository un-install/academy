package hw08;

import java.util.concurrent.BlockingQueue;

public class PersonProducer implements Runnable{
        private BlockingQueue queue = null;

        public PersonProducer(BlockingQueue queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                queue.put(new Person("Harry", 18, "McDonalds"));
                Thread.sleep(1000);
                queue.put(new Person("Garry", 19, "McDonalds"));
                Thread.sleep(1000);
                queue.put(new Person("Marry", 17, "McDonalds"));
                Thread.sleep(1000);
                queue.put(new Person("Darry", 20, "McDonalds"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
