package homework4;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Bank<Integer, Asset> bank = new Bank<>("Volodymirska 16");
        bank.map.put(15, new Currency(200));
        bank.map.put(16, new Gold(250));
        bank.map.put(17, new Stock(300));

        bank.withdraw(15, 100);
        bank.add(16, 200);
        bank.toZero(17);

        bank.map.forEach((k, v) -> System.out.println("account id: " + k + " balance: " + v.getQuantity() + " of " + v.getClass().getSimpleName()));
    }
}
