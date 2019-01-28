package hw12;

public class RoomOwner extends Person {
    public RoomOwner() {
        super();
    }

    public RoomOwner(String name, String surname, int yearOfBorn) {
        super(name, surname, yearOfBorn);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public void setSurname(String surname) {
        super.setSurname(surname);
    }

    @Override
    public int getYearOfBorn() {
        return super.getYearOfBorn();
    }

    @Override
    public void setYearOfBorn(int yearOfBorn) {
        super.setYearOfBorn(yearOfBorn);
    }
}
