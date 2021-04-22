package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Active: " + this.active);
        System.out.println("Status: " + this.status);
        System.out.println("Message: " + this.message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error firstError = new Error(true, 1, "First error");
        Error secondError = new Error(true, 2, "Second error");
        Error thirdError = new Error(false, 3, "Third error");
        error.printInfo();
        firstError.printInfo();
        secondError.printInfo();
        thirdError.printInfo();
    }
}
