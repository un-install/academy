package lesson20.Wrapper;

import lesson20.Pizza;

public class HotDelivery extends Delivery {

    @Override
    public Pizza deliver(Pizza pizza) {
        return makeHot(super.deliver(pizza));
    }

    private Pizza makeHot(Pizza pizza){
        pizza.setTemperature(pizza.getTemperature() + 25);
        return pizza;
    }
}
