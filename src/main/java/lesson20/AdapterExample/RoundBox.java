package lesson20.AdapterExample;

import static java.lang.Math.pow;

public class RoundBox {
    private float radius;

    public RoundBox(float radius) {
        this.radius = radius;
    }

    public float getSquere(){
        return (float)(2* pow(radius, 2) * 3.14);
    }
}
