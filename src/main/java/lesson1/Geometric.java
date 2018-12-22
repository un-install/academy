package lesson1;

public class Geometric {
    public static void main(String[] args) {
        System.out.println(progression(2, 3, 4));

    }

    public static int progression(int q, int b, int n) {

        if (n == 1)
            return b;
        else {
            n--;
            b *= q;
            return progression(q, b, n);
        }
    }
}
