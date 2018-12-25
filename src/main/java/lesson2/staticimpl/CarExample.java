package lesson2.staticimpl;

import lesson2.staticimpl.Car;

public class CarExample {
    public static class Sedan implements Car {
        private int speed = 10;

        @Override
        public void acelerate() {
            this.speed *= 2;
        }
    }

    public class Cabrio implements Car {
        private int speed = 10;

        @Override
        public void acelerate() {
            this.speed *= 1.5;
        }
    }
}
