package lesson20.Factory;

public class FactoryProducer {
    public static AbstractFactory createFactory(String fabricName){
        AbstractFactory factory;
        if ("PizzaHat".equals(fabricName)){
            factory = new PizzaHatFactory();
        }
        else {
            factory = new MamaMiaFactory();
        }
        return factory;
    }
}
