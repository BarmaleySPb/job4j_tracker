package ru.job4j.stream;

public class Auto {

    private String model;
    private String type;
    private byte doors;
    private byte wheels;
    private int engine;
    private int bagCapacity;
    private String color;
    private String number;

    @Override
    public String toString() {
        return "Auto{"
                + "model='" + model + '\''
                + ", type='" + type + '\''
                + ", doors=" + doors
                + ", wheels=" + wheels
                + ", engine=" + engine
                + ", bagCapacity=" + bagCapacity
                + ", color='" + color + '\''
                + ", number='" + number + '\''
                + '}';
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public byte getDoors() {
        return doors;
    }

    public byte getWheels() {
        return wheels;
    }

    public int getEngine() {
        return engine;
    }

    public int getBagCapacity() {
        return bagCapacity;
    }

    public String getColor() {
        return color;
    }

    public String getNumber() {
        return number;
    }

    static class Builder {
        private String model;
        private String type;
        private byte doors;
        private byte wheels;
        private int engine;
        private int bagCapacity;
        private String color;
        private String number;

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildType(String type) {
            this.type = type;
            return this;
        }

        Builder buildDoors(byte doors) {
            this.doors = doors;
            return this;
        }

        Builder buildWheels(byte wheels) {
            this.wheels = wheels;
            return this;
        }

        Builder buildEngine(int engine) {
            this.engine = engine;
            return this;
        }

        Builder buildBagCapacity(int bagCapacity) {
            this.bagCapacity = bagCapacity;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildNumber(String number) {
            this.number = number;
            return this;
        }

        Auto build() {
            Auto auto = new Auto();
            auto.model = model;
            auto.type = type;
            auto.doors = doors;
            auto.wheels = wheels;
            auto.engine = engine;
            auto.bagCapacity = bagCapacity;
            auto.color = color;
            auto.number = number;
            return auto;
        }
    }

    public static void main(String[] args) {
        Auto auto = new Builder().buildModel("Camry")
                .buildType("sedan")
                .buildWheels((byte) 4)
                .buildDoors((byte) 4)
                .buildBagCapacity(250)
                .buildEngine(3500)
                .buildColor("black")
                .buildNumber("a333aa98rus")
                .build();
        System.out.println(auto);
    }
}
