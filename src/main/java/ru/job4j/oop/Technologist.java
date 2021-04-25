package ru.job4j.oop;

public class Technologist extends Engineer {
    private String lastAttestation;
    private boolean canDocumentation;

    public Technologist() {
        super();
    }

    public Technologist(String name, String surname, String education, String birthDay,
                        int experience, String lastAttestation, boolean canDocumentation) {
        super(name, surname, education, birthDay, experience);
        this.lastAttestation = lastAttestation;
        this.canDocumentation = canDocumentation;
    }

    public void matchingDocs() {
    }
}
