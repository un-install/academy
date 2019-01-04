package homework5;

public enum FruitsEnum {
    STRAWBERRY("Red and round"), APPLE("Grow on treas"), PEA("Supersweet");

    private final String description;

    FruitsEnum (String desc){
        this.description = desc;
    }

    public String description() {
        return description;
    }
}
