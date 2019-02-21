package lesson20;

public abstract class Pizza {
    private float radius;
    private float weight;
    private int temperature;

    public Pizza() {

    }

    public Pizza(float radius) {
        this.radius = radius;
        weight = radius * 2;
        weightOfPeace = cutDaPeace();
    }

    public float getWeightOfPeace() {
        return weightOfPeace;
    }

    private float weightOfPeace;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
        weight = radius * 2;
        weightOfPeace = cutDaPeace();
    }

    public float getWeight() {
        return weight;
    }

    public abstract float cutDaPeace();

    public abstract void addMoreCheeze();

    @Override
    public String toString() {
        return "Pizza{" +
                "radius=" + radius +
                ", weight=" + weight +
                ", temperature=" + temperature +
                ", weightOfPeace=" + weightOfPeace +
                '}';
    }
}
