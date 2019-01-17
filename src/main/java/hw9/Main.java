package hw9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger resource = new AtomicInteger(0);
        CountThread countThread = new CountThread(resource);
        ExecutorService executor = Executors.newFixedThreadPool(6);
        List<Future<AtomicInteger>> results = new ArrayList<>();
        try {
            results.add(executor.submit(countThread));
            results.add(executor.submit(countThread));
            results.add(executor.submit(countThread));
            results.add(executor.submit(countThread));
            results.add(executor.submit(countThread));
            results.add(executor.submit(countThread));

            executor.shutdown();

            System.out.println(results.stream().count());
            results.forEach(f -> {
                try {
                    System.out.println(f.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
