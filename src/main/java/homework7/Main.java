package homework7;

import homework5.Fruits;
import homework6.Vitamins;
import lesson6.Animal;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static homework5.FruitsEnum.*;
import static homework6.Vitamins.*;

public class Main {
    public static void main(String[] args) {
        homework6.Main main = new homework6.Main();
        List<Fruits> fruits = new ArrayList<>();

        try {
            Method method = main.getClass().getDeclaredMethod("fillFruitsList");
            method.setAccessible(true);
            fruits = (ArrayList)method.invoke(main);

            //clone List
            List<Fruits> fruitsClone = new ArrayList<>();
            fruitsClone = fruits.stream().map(f -> deepClone(f)).collect(Collectors.toList());

            //provide some changes
            fruitsClone = fruitsClone.stream().peek(f -> {
                try {
                    f.setDeliveryDate(LocalDate.now());
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            ).collect(Collectors.toList());

            //output
            fruits.forEach(System.out::println);
            System.out.println();
            fruitsClone.forEach(System.out::println);

            //get private Constructor using reflex API
            Constructor constructor = Class.forName(Animal.class.getName()).getDeclaredConstructor();
            constructor.setAccessible(true);
            System.out.println("\n" + (Animal) constructor.newInstance());

            //fruitsClone.get(0).setDeliveryDate(LocalDate.of(2020,10,22));
            fruitsClone.get(0).setPrice(-5);

        }catch (Throwable e){
            e.printStackTrace();
        }

    }

    public static <T> T deepClone(T t){
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream ous = new ObjectOutputStream(baos);

            ous.writeObject(t);
            ous.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);

            return (T) ois.readObject();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
