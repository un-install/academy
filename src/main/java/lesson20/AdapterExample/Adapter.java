package lesson20.AdapterExample;
import lesson20.MamaMia.Peperony;
import lesson20.Pizza;

public class Adapter extends Pizza{
    SquerePie pie;

    public Adapter(SquerePie pie) {
        this.pie = pie;
        super.setRadius(pie.getSide() / 2);
    }

    @Override
    public float cutDaPeace() {
        return ((float)(super.getWeight() / 8));
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
