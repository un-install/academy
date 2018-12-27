package homework3.realization2;

public class Player6 extends ExpensivePlayer {
    public Player6(int price, String[] songs) {
        super(price, songs);
    }

    //shufle songs randomly swap first half elements with second's
    public void shufle(){
        String buff;
        for (int i = 0, randomIndex, lgth = super.soongs.length / 2; i < lgth; i++){

            //calculate and save tne random index for element from second part
            randomIndex = lgth + (int) (Math.random() * (lgth));

            //swap
            buff = super.soongs[i];
            super.soongs[i] = super.soongs[randomIndex];
            super.soongs[randomIndex] = buff;
        }
    }
}
