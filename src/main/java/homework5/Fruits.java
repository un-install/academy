package homework5;

import homework6.Vitamins;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Fruits implements Serializable {
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

    public void setDeliveryDate(LocalDate deliveryDate) throws Exception{
        if (deliveryDate.getYear() > LocalDate.now().getYear()) {
            throw new Exception("Fruits from future not allowed");
        }
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

    public void setPrice(int price) throws ArithmeticException{
        if (price <= 0) {
            throw new ArithmeticException("Price can be only positive");
        }
        this.price = price;
    }

    public void putOnlyFruit (Object o) {

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
