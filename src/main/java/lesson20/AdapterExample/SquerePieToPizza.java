package lesson20.AdapterExample;
import lesson20.MamaMia.Peperony;
import lesson20.Pizza;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class SquerePieToPizza extends Pizza{
    private SquerePie pie;

    public SquerePieToPizza(SquerePie pie) {
        this.pie = pie;
    }

    @Override
    public float getRadius() {
        return (float) (sqrt(2) / 2 * pie.getSide());
    }

    @Override
    public float cutDaPeace() {
        return (pie.getWeight() / 8);
    }

    @Override
    public void addMoreCheeze() {
        System.out.println("CHEZZE");
    }

    @Override
    public String toString() {
        return "SquerePie{" + "side: " + pie.getSide() + " weight: " + getWeight() +
                " temperature: " + getTemperature() + " weigth of peace: " + getWeightOfPeace() +
                '}';
    }
}
