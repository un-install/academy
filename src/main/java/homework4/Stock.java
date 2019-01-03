package homework4;

public class Stock extends Asset {
    public Stock(long quantity) {
        super(quantity);
    }

    public void fall() {
        System.out.println("Stocks are falling");
    }

}
