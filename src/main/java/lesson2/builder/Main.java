package lesson2.builder;

public class Main {
    public static void main(String[] args) {
        New nw = New.builder().withS("asd").withSa(12).withSt(15).build();
        System.out.println(nw);
    }
}
