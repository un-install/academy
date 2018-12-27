package lesson3;

public class Main {
    public static void main(String[] args) {
        TemplateDemo tmpl = new TemplateDemo(){

            @Override
            public void doOperation() {
                System.out.println("Read");
            }
        };

        tmpl.template();

        tmpl = new TemplateDemo() {
            @Override
            public void doOperation() {
                System.out.println("write");
            }
        };

        tmpl.template();
    }
}
