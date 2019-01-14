package hw08;

import java.util.concurrent.BlockingQueue;

public class PersonConsumer implements Runnable{
    private BlockingQueue queue = null;

    public PersonConsumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

