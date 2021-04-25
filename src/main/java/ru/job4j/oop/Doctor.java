package ru.job4j.oop;

public class Doctor extends Profession {
    private int experience;

    public Doctor() {
        super();
    }

    public Doctor(String name, String surname, String education, String birthDay, int experience) {
        super(name, surname, education, birthDay);
        this.experience = experience;
    }
}
