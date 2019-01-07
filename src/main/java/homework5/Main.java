package homework5;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FruitsStore store = new FruitsStore();

        store.add(new Fruits(FruitsEnum.STRAWBERRY,10, LocalDate.of(2019, Month.JANUARY, 2), 15, null));
        store.add(new Fruits(FruitsEnum.APPLE, 12, LocalDate.of(2018, Month.DECEMBER, 2), 7, null));
        store.add(new Fruits(FruitsEnum.APPLE,12, LocalDate.of(2019, Month.JANUARY, 1), 8, null));
        store.add(new Fruits(FruitsEnum.PEA,15, LocalDate.of(2018, Month.NOVEMBER, 2), 8, null));

        LocalDate date = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        System.out.println("Fresh fruits:");
        store.getFreshFruits(date).forEach(f -> System.out.println(f));

        System.out.println("\nApples:");
        store.getFruitsByType(FruitsEnum.APPLE).forEach(f -> System.out.println(f));

        System.out.println("\nFresh strawberries:");
        store.getFreshFruitsByType(FruitsEnum.STRAWBERRY, date).forEach(f -> System.out.println(f));

        System.out.println("\nfreshness term longer then 12:");
        store.getFruitsByFreshnesTerm(12).forEach(f -> System.out.println(f));

        System.out.println("\nSale:");
        store.doSale(5, date, 50, FruitsEnum.APPLE).forEach(f -> System.out.println(f));
    }
}
