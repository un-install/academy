package homework5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FruitsStore {
    private ArrayList<Fruits> fruits = new ArrayList<>();

    public void add (Fruits f) {
        fruits.add(f);
    }

    public List<Fruits> getFreshFruits(LocalDate date) {
        return fruits.stream().filter(fruit ->
                (fruit.getFreshnesTerm() >= this.lifeTimeCalc(date, fruit.getDeliveryDate())))
                .collect(Collectors.toList());
    }

    public List<Fruits> getFruitsByType(FruitsEnum fEnum) {
        return fruits.stream().filter(fruit ->
                fruit.getFEnum() == fEnum).collect(Collectors.toList());
    }

    public List<Fruits> getFruitsByFreshnesTerm (int freshnessTerm) {
        return fruits.stream().filter(fruit ->
                fruit.getFreshnesTerm() > freshnessTerm).collect(Collectors.toList());
    }

    public List<Fruits> getFreshFruitsByType (FruitsEnum fEnum, LocalDate date) {
        ArrayList<Fruits> f = new ArrayList<>(this.getFreshFruits(date));
        return f.stream().filter(fruit -> fruit.getFEnum() == fEnum).collect(Collectors.toList());
    }

    public void doSale (int realiztionTerm, LocalDate date, float percent, FruitsEnum... fEnums) {
            fruits = new ArrayList<>(fruits.stream().map(fruit ->
                    ((fruit.getFreshnesTerm() - this.lifeTimeCalc(date, fruit.getDeliveryDate())
                            < realiztionTerm && Arrays.stream(fEnums).anyMatch(fruit.getFEnum()::equals))
                            ? new Fruits(fruit.getFreshnesTerm(), fruit.getDeliveryDate(), (int) (fruit.getPrice() * (percent/100)), fruit.getFEnum()) : fruit))
                    .collect(Collectors.toList()));
    }

    public int lifeTimeCalc (LocalDate date, LocalDate creationDate) {
        return (date.getDayOfYear() + date.getYear()*365) - (creationDate.getDayOfYear() + creationDate.getYear()*365);
    }


    public void printStore () {
        fruits.forEach(f -> System.out.println(f));
    }
}
