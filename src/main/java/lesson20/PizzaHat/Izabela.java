package lesson20.PizzaHat;

import lesson20.Pizza;

public class Izabela extends Pizza {

    @Override
    public float cutDaPeace() {
        System.out.println("cuting Izabela");
        return getWeight()/10;
    }

    @Override
    public void addMoreCheeze(){
        System.out.println("add some cheese!");
    }

}
