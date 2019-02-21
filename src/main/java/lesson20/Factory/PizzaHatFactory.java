package lesson20.Factory;

import lesson20.Factory.AbstractFactory;
import lesson20.Pizza;
import lesson20.PizzaHat.Izabela;
import lesson20.PizzaHat.Marmon;

public class PizzaHatFactory extends AbstractFactory {

    @Override
    public Pizza createPizza(String order) {
        Pizza pizza;
        if ("Izabela".equals(order)) {
            pizza = new Izabela();
        } else {
            pizza = new Marmon();
        }

        return pizza;
    }
}
