package ru.job4j.oop;

public class Story {

    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        Pioneer petya = new Pioneer();
        Girl girl = new Girl();
        girl.help(petya);
        wolf.eat(girl);
        petya.kill(wolf);
    }
}
