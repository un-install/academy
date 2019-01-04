package homework5;

import java.time.LocalDate;

public class Fruits {
    private int freshnesTerm;
    private LocalDate deliveryDate;
    private int price;
    private FruitsEnum fEnum;

    public Fruits(int freshnesTerm, LocalDate deliveryDate, int price, FruitsEnum fEnum) {
        this.freshnesTerm = freshnesTerm;
        this.deliveryDate = deliveryDate;
        this.price = price;
        this.fEnum = fEnum;
    }

    public int getFreshnesTerm() {
        return freshnesTerm;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public int getPrice() {
        return price;
    }

    public FruitsEnum getFEnum() {
        return fEnum;
    }

    @Override
    public String toString() {
        return "Fruits{" +
                "freshnesTerm=" + freshnesTerm +
                ", deliveryDate=" + deliveryDate +
                ", price=" + price +
                 " " + fEnum + " " + fEnum.description()+
                '}';
    }
}
