package lesson20.MamaMia;

import lesson20.Pizza;

public class Peperony extends Pizza {

    public Peperony() {
    }

    public Peperony(float radius) {
        super(radius);
    }

    @Override
    public float cutDaPeace() {
        System.out.println("cutting peace of pepe");
        return super.getWeight()/8;
    }

    //imaginary difficult operation
    @Override
    public void addMoreCheeze(){
        System.out.println("add some cheese!");
    }
}
