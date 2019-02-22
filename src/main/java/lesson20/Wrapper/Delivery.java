package lesson20.Wrapper;

import lesson20.Factory.AbstractFactory;
import lesson20.Factory.FactoryProducer;
import lesson20.Pizza;

import static java.lang.Math.pow;

public class Delivery {

    public Pizza deliver(Pizza pizza){
        System.out.println("Squere of a box (sm^2) is: " + putPizzaInBox(pizza.getRadius()));

        pizza.setTemperature(25);
        return pizza;
    }

    //for adapter
    private double putPizzaInBox(float radius){
        return pow(radius * 2, 2);
    }
}
