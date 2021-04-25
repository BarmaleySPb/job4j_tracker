package ru.job4j.oop;

public class Surgeon extends Doctor {
    private boolean neuroSurgery;
    private int numOfOperations;

    public Surgeon() {
        super();
    }

    public Surgeon(String name, String surname, String education, String birthDay,
                   int experience, boolean neuroSurgery, int numOfOperations) {
        super(name, surname, education, birthDay, experience);
        this.neuroSurgery = neuroSurgery;
        this.numOfOperations = numOfOperations;
    }

    public void operation() {
    }
}
