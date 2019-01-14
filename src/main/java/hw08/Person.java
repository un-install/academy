package hw08;

import java.util.Objects;

public class Person {
    volatile String name;
    volatile int age;
    volatile String work;

    public Person(String name, int age, String work) {
        this.name = name;
        this.age = age;
        this.work = work;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(work, person.work);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, work);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", work='" + work + '\'' +
                '}';
    }
}
