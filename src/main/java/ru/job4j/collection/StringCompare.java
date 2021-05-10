package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        char[] leftArray = left.toCharArray();
        char[] rightArray = right.toCharArray();
        for (int i = 0; i < Math.min(leftArray.length, rightArray.length); i++) {
            rsl += Character.compare(leftArray[i], rightArray[i]);
            if (rsl != 0) {
                return rsl;
            }
        }
        if (leftArray.length == rightArray.length) {
            return rsl;
        }
        return leftArray.length < rightArray.length ? -1 : 1;
    }
}