package ru.job4j.poly;

public class Bus implements Transport {

    private short passengers;

    @Override
    public void move() {
    }

    @Override
    public void passengers(short quantity) {
        this.passengers = quantity;
    }

    @Override
    public int refuel(short valueOfFuel) {
        int priceOfGas = 5;
        return valueOfFuel * priceOfGas;
    }
}
