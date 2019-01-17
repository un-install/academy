package hw9;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class CountThread implements Callable<AtomicInteger> {
    private AtomicInteger rs;

    public CountThread(AtomicInteger rs) {
        this.rs = rs;
    }

    public AtomicInteger getRs() {
        return rs;
    }

    @Override
    public AtomicInteger call() {
        try {
            for (int i = 0; i < 500; i++){
                rs.incrementAndGet();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }
}
