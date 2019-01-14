package lesson7;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            /**`MathUtil.div(1, 0);
             MathUtil.mult(0, 2);
             MathUtil.mult(2, 2);**/
        } catch (Exception e) {
            e.printStackTrace();
        }

        Counter counter = new Counter();

        Runnable runable = () -> {
            for (int i = 0; i < 5000; i++) {
                counter.increment();
            }
        };

        new Thread(runable).start();
        new Thread(runable).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter.getCounter());

        ArrayList<Object> list = new ArrayList<>();

        Collections.synchronizedCollection(list);

    }
}
