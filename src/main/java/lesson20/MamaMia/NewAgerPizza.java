package lesson20.MamaMia;

import lesson20.Pizza;

public class NewAgerPizza extends Pizza {
    @Override
    public float cutDaPeace() {
        System.out.println("fuck off new ager");
        return super.getWeight()/8;
    }

    @Override
    public void addMoreCheeze(){
        System.out.println("add some cheese!");
    }
}
