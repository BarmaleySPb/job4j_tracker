package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Api {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 4, -5, 7, -10, 34, 54, -45);
        ArrayList<Integer> list = new ArrayList<>(numbers);
        List<Integer> negNum = list.stream()
                .filter(stream -> stream > 0).toList();
        System.out.println(negNum);
    }
}
