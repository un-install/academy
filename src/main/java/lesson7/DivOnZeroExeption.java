package lesson7;

public class DivOnZeroExeption extends RuntimeException {
    private String m = "Dividing on zero exception";
    public DivOnZeroExeption (String m) {
        super(m);
    }
}
