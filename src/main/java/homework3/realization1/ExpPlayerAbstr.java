package homework3.realization1;

abstract public class ExpPlayerAbstr extends Playerabstr implements ExpensivePlayer{

    ExpPlayerAbstr(int price, String[] songs) {
        super(price, songs);
    }

    @Override
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
