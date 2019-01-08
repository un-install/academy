package homework5;

import homework6.Vitamins;

import java.time.LocalDate;
import java.util.List;

public class Fruits {
    private int freshnesTerm;
    private LocalDate deliveryDate;
    private int price;
    private FruitsEnum fEnum;
    private List<Vitamins> vitamins;

    public Fruits(FruitsEnum fEnum, int freshnesTerm, LocalDate deliveryDate, int price, List<Vitamins> vitamins) {
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

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getPrice() {
        return price;
    }

    public FruitsEnum getFEnum() {
        return fEnum;
    }

    public List<Vitamins> getVitamins () {
        return vitamins;
    }

    public void setVitamins (List<Vitamins> vitamins) {
        this.vitamins = vitamins;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Fruits{" +
                "freshnesTerm=" + freshnesTerm +
                ", deliveryDate=" + deliveryDate +
                ", price=" + price +
                ", fEnum=" + fEnum +
                ", vitamins=" + vitamins +
                '}';
    }
}
