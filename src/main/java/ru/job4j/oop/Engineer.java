package ru.job4j.oop;

public class Engineer extends Profession {
    private int experience;

    public Engineer() {
        super();
    }

    public Engineer(String name, String surname, String education, String birthDay,
                    int experience) {
        super(name, surname, education, birthDay);
        this.experience = experience;
    }
}
