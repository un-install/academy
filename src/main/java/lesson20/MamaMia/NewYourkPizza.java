package lesson20.MamaMia;

import lesson20.Pizza;

public class NewYourkPizza extends Pizza {
    @Override
    public float cutDaPeace() {
        System.out.println("cutting New york pizza");
        return super.getWeight()/8;
    }

    @Override
    public void addMoreCheeze(){
        System.out.println("add some cheese!");
    }
}
