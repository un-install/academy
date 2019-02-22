package lesson20.MamaMia;

import lesson20.Pizza;

public class FloridaPizza extends Pizza {
    @Override
    public float cutDaPeace() {
        System.out.println("cutting Florida pizza");
        return super.getWeight()/8;
    }

    @Override
    public void addMoreCheeze(){
        System.out.println("add some cheese!");
    }
}
