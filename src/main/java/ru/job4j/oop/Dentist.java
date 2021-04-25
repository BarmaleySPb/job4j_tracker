package ru.job4j.oop;

public class Dentist extends Doctor {
    private boolean canSurgeon;
    private String specialization;

    public Dentist() {
        super();
    }

    public Dentist(String name, String surname, String education, String birthDay,
                   int experience, boolean canSurgeon, String specialization) {
        super(name, surname, education, birthDay, experience);
        this.canSurgeon = canSurgeon;
        this.specialization = specialization;
    }
}
