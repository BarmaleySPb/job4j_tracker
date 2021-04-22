package ru.job4j.oop;

public class Battery {

    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load += this.load;
    }

    public static void main(String[] args) {
        Battery battery = new Battery(20);
        Battery toyMachine = new Battery(0);
        battery.exchange(toyMachine);
        System.out.println("Charge of toyMachine is: " + toyMachine.load);
    }
}
