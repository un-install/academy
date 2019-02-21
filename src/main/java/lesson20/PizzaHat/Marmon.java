package lesson20.PizzaHat;

import lesson20.Pizza;

public class Marmon extends Pizza {
    @Override
    public float cutDaPeace() {
        System.out.println("cutting marmon ");
        return getWeight()/10;
    }

    @Override
    public void addMoreCheeze(){
        System.out.println("add some cheese!");
    }
}
