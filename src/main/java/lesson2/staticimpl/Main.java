package lesson2.staticimpl;

import lesson2.staticimpl.Car;
import lesson2.staticimpl.CarExample;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Car cabrio = new CarExample().new Cabrio();
        Car sedan = new CarExample.Sedan();

        Car car = new Car(){
            private int speed = 10;
            @Override
            public void acelerate() {
                this.speed *= 3;
            }
        };

        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(cabrio);
        cars.add(sedan);
        cars.add(car);

        cars.stream().map(cari -> cari.getClass().getName() + "cur speed after = " + cari.speed);




    }
}
