package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        String[] list = {"one", "two", "three", "four", "five", "six", "seven"};
        BiConsumer<Integer, String> biCon = (num, string) -> map.put(num, string);
        int j = 1;
        for (String item : list) {
            biCon.accept(j++, item);
        }
        System.out.println(map);

        BiPredicate<Integer, String> biPred = (i, s) -> i % 2 == 0 || map.get(i).length() == 4;
        for (Integer i : map.keySet()) {
            if (biPred.test(i, map.get(i))) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }

        Supplier<List<String>> sup = () -> new ArrayList<String>(map.values());
        Consumer<String> con = (s) -> System.out.println(s);
        Function<String, String> func = s -> s.toUpperCase();
        for (String string : sup.get()) {
            con.accept(func.apply(string));
        }
    }
}