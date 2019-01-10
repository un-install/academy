package lesson6;

import java.lang.reflect.Method;
import java.util.Arrays;


public class MainReflex {
    public static void main(String[] args) throws Exception {
        Animal animal = new Animal("la", 12);

        Method[] methods  = animal.getClass().getDeclaredMethods();
        Arrays.asList(methods).forEach(System.out::println);

        Method method = animal.getClass().getDeclaredMethod("someInternalLogic");
        method.setAccessible(true);
        method.invoke(animal);
        System.out.println(animal);
    }
}
