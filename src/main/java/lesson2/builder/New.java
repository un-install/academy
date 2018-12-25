package lesson2.builder;

public class New {
    private int st;
    private String s;
    private int sa;

    private New(Builder builder){
        this.st = builder.st;
        this.s = builder.s;
        this.sa = builder.sa;
    }

    @Override
    public String toString() {
        return "New{" +
                "st=" + st +
                ", s='" + s + '\'' +
                ", sa=" + sa +
                '}';
    }

    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder {
        private int st;
        private String s;
        private int sa;

        public Builder withSt(int st){
            this.st = st;
            return this;
        }

        public Builder withS(String s){
            this.s = s;
            return this;
        }

        public Builder withSa(int sa){
            this.sa = sa;
            return this;
        }

        public New build(){
         return new New(this);
        }
    }
}
