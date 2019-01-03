package homework4;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Bank<Asset> bank = new Bank<>("Volodymirska 16");
        bank.put(new Currency(200));
        bank.put(new Gold(250));
        bank.put(new Stock(300));

        bank.withdraw(15, "Gold");
        bank.put(new Gold(300));
        bank.printBank();
    }
}
