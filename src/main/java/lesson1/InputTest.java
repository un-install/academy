package lesson1;

import java.util.Scanner;

public class InputTest {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String i = sc.nextLine();
            System.out.println(i.toUpperCase());
        }
    }
}