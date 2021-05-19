package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class ArrayToList {

    public static List<Integer> twoDimArray(Integer[][] array) {
        List<List<Integer>> matrix = new ArrayList<>();
        for (Integer[] elem : array) {
            matrix.add(new ArrayList<>(asList(elem)));
        }
        return matrix.stream()
                .flatMap(e -> e.stream())
                .collect(Collectors.toList());
    }
}
