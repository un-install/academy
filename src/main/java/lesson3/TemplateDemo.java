package lesson3;

public abstract class TemplateDemo {
    public void open(){
        System.out.println("Open");
    }

    public void close(){
        System.out.println("Close");
    }

    public abstract void doOperation();

    public void template(){
        doOperation();
        open();
        close();
    }
}
