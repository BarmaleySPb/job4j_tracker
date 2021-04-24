package ru.job4j.pojo;

public class Book {
    private String name;
    private int valueOfPage;

    public Book() {
    }

    public Book(String name, int valueOfPage) {
        this.name = name;
        this.valueOfPage = valueOfPage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValueOfPage() {
        return valueOfPage;
    }

    public void setValueOfPage(int valueOfPage) {
        this.valueOfPage = valueOfPage;
    }
}
