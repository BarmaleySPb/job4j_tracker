package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayToList {

    public static List<Integer> twoDimArray(Integer[][] array) {
        return Arrays.stream(array)
                .flatMap(Stream::of)
                .collect(Collectors.toList());
    }
}
