package ru.job4j.oop;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " движется по дороге");
    }

    @Override
    public void fuel() {
        System.out.println(getClass().getSimpleName() + " использует бензин");
    }
}
