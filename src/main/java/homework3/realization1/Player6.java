package homework3.realization1;

public class Player6 extends ExpPlayerAbstr {
    public Player6(int price, String[] songs) {
        super(price, songs);
    }


    //
    public void shufle(){
        String buff;
        for (int i = 0, randomIndex, lgth = super.soongs.length / 2; i < lgth; i++){
            randomIndex = lgth + (int) (Math.random() * (lgth));
            buff = super.soongs[i];
            super.soongs[i] = super.soongs[randomIndex];
            super.soongs[randomIndex] = buff;
        }
    }
}
