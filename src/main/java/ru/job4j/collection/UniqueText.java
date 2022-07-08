package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueText {

    public static boolean isEquals(String originText, String duplicateText) {
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        Set<String> check = new HashSet<>(Arrays.stream(origin).toList());
        for (String word : text) {
            if (!check.contains(word)) {
                return false;
            }
        }
        return true;
    }
}