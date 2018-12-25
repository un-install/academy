package lesson2;

import lesson1.Temp;

import java.sql.SQLOutput;
import java.util.Objects;

public class PojoExample {
    private int something;
    private int somethingElse;
    private int somethingElseElse;
    private String line;

    public PojoExample(int something, int somethingElse, int somethingElseElse, String line) {
        this.something = something;
        this.somethingElse = somethingElse;
        this.somethingElseElse = somethingElseElse;
        this.line = line;
    }

    public void some(Object... obj){
        System.out.println(obj[0]);
    }

    public void setSomething(int something) {
        this.something = something;
    }

    public void setSomethingElse(int somethingElse) {
        this.somethingElse = somethingElse;
    }

    public void setSomethingElseElse(int somethingElseElse) {
        this.somethingElseElse = somethingElseElse;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getSomething() {
        return something;
    }

    public int getSomethingElse() {
        return somethingElse;
    }

    public int getSomethingElseElse() {
        return somethingElseElse;
    }

    public String getLine() {
        return line;
    }

    @Override
    public String toString() {
        return "PojoExample{" +
                "something=" + something +
                ", somethingElse=" + somethingElse +
                ", somethingElseElse=" + somethingElseElse +
                ", line='" + line + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PojoExample that = (PojoExample) o;
        return something == that.something &&
                somethingElse == that.somethingElse &&
                somethingElseElse == that.somethingElseElse &&
                Objects.equals(line, that.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(something, somethingElse, somethingElseElse, line);
    }

    public static void main(String[] args) {
      PojoExample p1 = new PojoExample(13, 13, 14, "asdasd");
      PojoExample p2 = new PojoExample(13, 13, 14, "asdasd");
      System.out.println(p1.equals(p2));
    }

}
