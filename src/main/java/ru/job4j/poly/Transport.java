package ru.job4j.poly;

public interface Transport {

    void move();

    void passengers(short quantity);

    int refuel(short valueOfFuel);
}
