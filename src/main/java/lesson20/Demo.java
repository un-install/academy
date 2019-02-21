package lesson20;

import lesson20.AdapterExample.Adapter;
import lesson20.AdapterExample.SquerePie;
import lesson20.Factory.AbstractFactory;
import lesson20.Factory.FactoryProducer;
import lesson20.Pizza;
import lesson20.ProxyPizza.ProxyPeperony;
import lesson20.Wrapper.Delivery;
import lesson20.Wrapper.HotDelivery;

public class Demo {
    public static void main(String[] args) {
        Delivery delivery = new Delivery();
        Delivery hotDelivery = new HotDelivery();

        System.out.println(delivery.deliver(makePizza("New York", 45, "MamaMia")));
        System.out.println(delivery.deliver(makePizza("Peperony", 35, "MamaMia")));
        System.out.println(delivery.deliver(makePizza("Ukrainian", 45, "MamaMia")));
        //HotDelivery is wrapper of delivery
        System.out.println(hotDelivery.deliver(makePizza("Florida", 45, "MamaMia")));
        System.out.println(hotDelivery.deliver(makePizza("Im Blue", 50, "MamaMia")));
        System.out.println(hotDelivery.deliver(makePizza("Izabela", 50, "PizzaHat")));
        System.out.println(hotDelivery.deliver(makePizza("Marmon", 50, "PizzaHat")));

        //using of adapter
        SquerePie pie = new SquerePie(50);
        System.out.println(hotDelivery.deliver(new Adapter(pie)));

        Pizza proxyPepe = new ProxyPeperony(35);
        System.out.println(delivery.deliver(proxyPepe));
        proxyPepe.addMoreCheeze();

    }

    //using fo factories
    public static Pizza makePizza(String order, float radius, String manufacurer) {
        AbstractFactory factory = FactoryProducer.createFactory(manufacurer);
        Pizza pizza = factory.createPizza(order);
        System.out.println(factory.getClass().getSimpleName());
        pizza.setRadius(radius);
        return pizza;
    }
}