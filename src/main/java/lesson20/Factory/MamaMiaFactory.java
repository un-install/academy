package lesson20.Factory;

import lesson20.Factory.AbstractFactory;
import lesson20.MamaMia.*;
import lesson20.Pizza;

public class MamaMiaFactory extends AbstractFactory {

    @Override
    public Pizza createPizza(String order){
        Pizza pizza;
        if ("Im Blue".equals(order)){
            pizza = new NewAgerPizza();
        }
        else if ("New York".equals(order)){
            pizza = new NewYourkPizza();
        }
        else if ("Peperony".equals(order)) {
            pizza = new Peperony();
        }
        else if ("Florida".equals(order)){
            pizza = new FloridaPizza();
        }
        else {
            pizza = new UkrainianPizza();
        }

        return pizza;
    }
}
