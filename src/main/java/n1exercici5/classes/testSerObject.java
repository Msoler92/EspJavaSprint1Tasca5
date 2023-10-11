package n1exercici5.classes;

import java.io.Serializable;

public class testSerObject implements Serializable {
    private String name;
    private int age;
    public boolean active;

    public testSerObject(String name, int age, boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public String toString() {
        return "name = " + name + ", age = " + age + ", active = " + active;
    }
}
