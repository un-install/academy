package homework4;

public class Currency extends Asset {
    public Currency(long quantity) {
        super(quantity);
    }

    public void burn() {
        System.out.println("papers are burn");
    }
}
