package model;

public class Student extends Person {

    private int id;

    public Student(int id, String name) {
        super(name); // calls Person constructor
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
