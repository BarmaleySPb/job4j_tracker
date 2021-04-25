package ru.job4j.oop;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private String birthDay;

    public Profession() {
    }

    public Profession(String name, String surname, String education, String birthDay) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
}
