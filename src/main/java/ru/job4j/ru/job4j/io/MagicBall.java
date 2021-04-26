package ru.job4j.ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your question ");
        String question = scanner.nextLine();
        String answer = switch (new Random().nextInt(3)) {
            case 0 -> "Yes";
            case 1 -> "No";
            default -> "May be";
        };
        System.out.println(answer);
    }
}