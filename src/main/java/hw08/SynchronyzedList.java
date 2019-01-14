package hw08;

import java.util.ArrayList;
import java.util.Comparator;

public class SynchronyzedList<T> extends ArrayList<T> {

    public SynchronyzedList(){
        super();
    }

    //example of using sync method
    @Override
    public synchronized boolean add(T t){
        return super.add(t);
    }

    //There is no critical need in sync
    //but if some thread will update value in list
    //you can get an outdated version
    @Override
    public T get(int i) {
        return super.get(i);
    }

    //example of sync block
    @Override
    public void sort(Comparator<? super T> comparator) {
        synchronized (this) {
            super.sort(comparator);
        }
    }
}