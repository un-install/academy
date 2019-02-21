package lesson20.Factory;

import lesson20.Pizza;

public abstract class AbstractFactory {
    public abstract Pizza createPizza(String order);
}
