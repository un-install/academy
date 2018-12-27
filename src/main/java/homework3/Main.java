package homework3;

//to test another realization just change the number in import
import homework3.realization2.*;

public class Main {
    public static void main(String[] args) {
        String[] songs = new String[]{"s1","s2", "s3", "s4", "s5", "s6", "s7"};

        Player1 p1 = new Player1(14, songs);
        Player1 p2 = new Player1(15, songs);
        Player3 p3 = new Player3(17, songs);
        Player3 p4 = new Player3(20, songs);
        Player3 p5 = new Player3(26, songs);
        Player6 p6 = new Player6(34, songs);

        System.out.println(p6.getPrice());
        p6.shufle();
        p6.playSong();
        p6.playALLSongS();
    }
}
