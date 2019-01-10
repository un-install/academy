package homework6;

import homework5.Fruits;
import homework5.FruitsEnum;
import homework5.FruitsStore;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static homework6.Vitamins.*;
import static homework5.FruitsEnum.*;

public class Main {
    public static void main(String[] args) {
        List<Fruits> fruits = fillFruitsList();
        LocalDate date = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        fruits.forEach(System.out::println);
        System.out.println();

        //Output quantity of fruits in list within vitamin B
        //using filter, anyMatch, forEach, count
        System.out.println("Vitamin B riched: " + fruits.stream().filter(f -> f.getVitamins().stream().anyMatch(B::equals)).count());
        System.out.println();

        //output fruits list without first two element
        //using skip, forEachOrdered
        System.out.println("Fruits from third: ");
        fruits.stream().skip(2).forEachOrdered(f -> System.out.println(f));
        System.out.println();

        //output fruits without duplicates
        //using distinct
        System.out.println("Fruits distincted: ");
        fruits.stream().distinct().forEach(f -> System.out.println(f));
        System.out.println();

        //change deliveryDate label for all outdated fruits from first half of list
        //output stream in one line
        //using map, limit
        System.out.println("Changed deliveryDate for all outdated:");
        fruits.stream().limit(fruits.size() / 2).map(f -> isOutdated(date, f)
        ? new Fruits(f.getFEnum(), f.getFreshnesTerm(), date, f.getPrice(), f.getVitamins()): f).forEach(System.out::println);
        System.out.println("\n");

        //rise price twice
        //using peek
        System.out.println("Price twice raised:");
        fruits.stream().peek(f -> f.setPrice(f.getPrice()*2)).forEach(System.out::println);
        System.out.println();

        //output all HashCodes from min to max
        //using mapToLong, sorted
        System.out.println("Sorted list of hashCodes: ");
        fruits.stream().mapToLong(f -> f.hashCode()).sorted().forEach(System.out::println);
        System.out.println();

        //output freshTerm belong amount of stored days with convertion to array
        //using flatMap, toArray

        int[] times = fruits.stream().flatMapToInt(fs ->
                IntStream.of(fs.getFreshnesTerm(),FruitsStore.lifeTimeCalc(date, fs.getDeliveryDate())))
                .toArray();

        System.out.println("TErm belong lifeTime: ");
        for (int i : times)
            System.out.print(i + ", ");
        System.out.println("\n");

        //Output first outdated element of stream in right order
        //using findFirst
        System.out.println("first outdated element: ");
        System.out.println(fruits.stream().filter(f -> isOutdated(date, f)).findFirst().get());
        System.out.println();

        //the same but without ordering
        //using findAny
        System.out.println("any outdated element");
        System.out.println(fruits.stream().filter(f -> isOutdated(date, f)).findAny().get());
        System.out.println();

        //If there is no outdated fruits print "Fresh fruits"
        //using noneMatch
        if (fruits.stream().noneMatch(f -> isOutdated(date, f))) {
            System.out.println("Fresh fruits!");
        }
        else {
            System.out.println("There is outdated fruits");
        }
        System.out.println();

        //If all fruits are outdated print "All are spoiled"
        //Using allMatch
        if (fruits.stream().allMatch(f -> isOutdated(date, f))) {
            System.out.println("All are spoiled!");
        }
        System.out.println();

        //output fruit with max HashCode
        //using max
        System.out.println("max hashcode:\n " +fruits.stream().max(Comparator.comparing(f -> f.hashCode())).get());
        System.out.println();

        //output fruit with min FreshTerm
        //using min
        System.out.println("min hashcode: \n" +fruits.stream().min(Comparator.comparing(f -> f.getFreshnesTerm())).get());
        System.out.println();

        //output fruit which is  oldest in store
        //using reduce
        System.out.println("Oldest Fruit: \n" + fruits.stream().reduce((f1, f2) -> FruitsStore
                .lifeTimeCalc(date, f1.getDeliveryDate()) > FruitsStore.lifeTimeCalc(date, f2.getDeliveryDate()) ? f1 : f2).get());
        System.out.println();




        /**Lesson 6**/
        fruits.stream().forEach(f -> System.out.println(f + ": " + f.getVitamins()));
        System.out.println();

        fruits.stream().flatMap(f -> (f.getVitamins().stream())).distinct().forEach(f -> System.out.print(f + ","));

        Stream<LocalDate> st = fruits.stream().map(f -> f.getDeliveryDate());
        List<LocalDate> deliveryDates = st.collect(Collectors.toList());
        deliveryDates.forEach(System.out::println);

        ArrayDeque<LocalDate> dD = fruits.stream().map(f -> f.getDeliveryDate()).collect(Collectors.toCollection(ArrayDeque::new));
        dD.forEach(System.out::println);

        Map<Integer, Fruits> fts = fruits.stream().collect(Collectors
                .toMap(f -> f.getPrice(), Function.identity(), (f1, f2) -> f1));
        fts.forEach((p,f) -> System.out.println(p + " " + f));
        System.out.println();

        fruits.stream().map(f -> f.getFEnum().toString()).distinct().collect(Collectors.joining(",", "[", "]"));
        Map<FruitsEnum, List<Fruits>> groupedFruits = fruits.stream().collect(Collectors.groupingBy(Fruits::getFEnum));
        groupedFruits.forEach((k,v) -> System.out.println(k + "" + v));


    }

    private static List<Fruits> fillFruitsList() {
        List<Fruits> fruits = new ArrayList<>();

        Fruits fruit = new Fruits(APPLE, 30, LocalDate.of(2018, 1, 4), 12, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { B, C }));
        fruits.add(fruit);

        fruit = new Fruits(STRAWBERRY, 15, LocalDate.of(2019, 1, 2), 50, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { A, C }));
        fruits.add(fruit);

        fruit = new Fruits(PEA, 30, LocalDate.of(2019, 1, 4), 40, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { A, B1, B2, C }));
        fruits.add(fruit);

        fruit = new Fruits(ORANGE, 60, LocalDate.of(2019, 1, 3), 30, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { E, B, A }));
        fruits.add(fruit);

        fruit = new Fruits(STRAWBERRY, 25, LocalDate.of(2019, 1, 2), 60, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { A, C, D }));
        fruits.add(fruit);

        fruit = new Fruits(PEA, 15, LocalDate.of(2019, 1, 4), 40, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { A, B, B1, B2, P }));
        fruits.add(fruit);

        fruit = new Fruits(PEA, 5, LocalDate.of(2019, 1, 6), 10, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { B1, B2, P }));
        fruits.add(fruit);

        fruit = new Fruits(APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { B, C }));
        fruits.add(fruit);



        return fruits;

    }

    //ce costyl
    public static boolean isOutdated (LocalDate date, Fruits f){
        return FruitsStore.lifeTimeCalc(date, f.getDeliveryDate()) > f.getFreshnesTerm();
    }
}
