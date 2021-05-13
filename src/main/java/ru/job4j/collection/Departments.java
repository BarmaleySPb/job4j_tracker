package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> temp = new LinkedHashSet<>();
        for (String item : deps) {
            String ell = "";
            for (String el : item.split("/")) {
                ell += el;
                temp.add(ell);
                ell += "/";
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("k2/sk1/sk2/sk3", "k4/sk1", "k1/sk1", "k2", "k2/sk1/sk2/sk5");
        list = fillGaps(list);
        sortDesc(list);
        for (String item : list) {
            System.out.println(item);
        }
    }
}