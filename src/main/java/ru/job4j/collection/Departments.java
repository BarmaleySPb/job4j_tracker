package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> temp = new LinkedHashSet<>();
        for (String item : deps) {
            StringBuilder ell = new StringBuilder();
            for (String el : item.split("/")) {
                ell.append(el);
                temp.add(ell.toString());
                ell.append("/");
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> args) {
        Collections.sort(args);
    }

    public static void sortDesc(List<String> args) {
        args.sort(new DepDescComp());
    }
}