package lesson20.AdapterExample;

public class SquerePie {
    private float side;
    private float weight;

    public float getWeight() {
        return weight;
    }

    public SquerePie(float side) {
        this.side = side;
        weight = (float)(side * 2.25);
    }

    public float getSide() {
        return side;
    }

    public void setSide(float side) {
        this.side = side;
    }
}
