package ru.job4j.oop;

public class Builder extends Engineer {
    private boolean canBricks;
    private boolean canConcrete;

    public Builder() {
        super();
    }

    public Builder(String name, String surname, String education, String birthDay,
                   int experience, boolean canBricks, boolean canConcrete) {
        super(name, surname, education, birthDay, experience);
        this.canBricks = canBricks;
        this.canConcrete = canConcrete;
    }

    public void build() {
    }
}
