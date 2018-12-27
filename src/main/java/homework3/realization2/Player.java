package homework3.realization2;

abstract public class Player {
    String soongs[];
    private final int price;

    Player (int price, String[] songs){
        this.price = price;
        this.soongs =songs;
    }

    public void playSong() {
        System.out.println(this.soongs[0]);
    }

    public int getPrice() {
        return this.price;
    }
}

