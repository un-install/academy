package homework3.realization1;

abstract public class Playerabstr implements Player{
    String soongs[];
    private final int price;

    Playerabstr (int price, String[] songs){
        this.price = price;
        this.soongs =songs;
    }

    @Override
    public void playSong() {
        System.out.println(this.soongs[0]);
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
