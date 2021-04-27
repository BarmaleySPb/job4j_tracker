package ru.job4j.oop;

public class Transport {

    public static void main(String[] args) {
        Bus bus = new Bus();
        Train train = new Train();
        Plane plane = new Plane();
        Vehicle vehicleBus = bus;
        Vehicle vehicleTrain = train;
        Vehicle vehiclePlane = plane;
        Vehicle[] vehicles = {vehicleBus, vehicleTrain, vehiclePlane};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.fuel();
        }
    }
}
