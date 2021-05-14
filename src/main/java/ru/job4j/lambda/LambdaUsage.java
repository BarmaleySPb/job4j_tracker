package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("dfgfhdgh", "fghdhd", "fgsdfsglfhgsl", "wer");

        Comparator<String> comparatorLength = (left, right) -> {
            System.out.println("compare - " + right.length() + " : " + left.length());
            return right.length() - left.length();
        };

        list.sort(comparatorLength);
        System.out.println(list);
    }
}
