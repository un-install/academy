package homework3.realization2;

abstract public class ExpensivePlayer extends Player{
    ExpensivePlayer(int price, String[] songs) {
        super(price, songs);
    }

    public void playALLSongS() {
        for(int i = 0; i < super.soongs.length; i++)
            System.out.println(soongs[i]);
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public void playSong() {
        super.playSong();
    }

}
