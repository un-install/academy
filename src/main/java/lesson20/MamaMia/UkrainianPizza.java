package lesson20.MamaMia;

import lesson20.Pizza;

public class UkrainianPizza extends Pizza {
    @Override
    public float cutDaPeace() {
        System.out.println("now you re ill");
        return super.getWeight()/8;
    }

    @Override
    public void addMoreCheeze(){
        System.out.println("add some cheese!");
    }

}
