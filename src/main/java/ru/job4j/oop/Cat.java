package ru.job4j.oop;

public class Cat {

    private String food;
    private String name;

    public void show() {
        System.out.println(this.name + " eats " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public String sound() {
        String voice = "may - may";
        return voice;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        Cat black = new Cat();
        Cat peppy = new Cat();
        Cat sparky = new Cat();
        gav.giveNick("Gav");
        black.giveNick("Black");
        gav.eat("kotleta");
        black.eat("fish");
        String say = peppy.sound();
        System.out.println("Peppy says " + say);
        gav.show();
        black.show();
    }
}
