package lesson7;

public class MathUtil{
    public static int mult (int a, int b) throws Exception {
        if (a == 0 || b == 0) {
            throw new ArgumentZeroExeption("Zero argument");
        }
        if (a == b) {
            throw new Exception();
        }

        return a * b;
    }

    public static int div (int a, int b){
        if (b == 0) {
            throw new DivOnZeroExeption ("Div on zero");
        }
        return a / b;

    }
}
