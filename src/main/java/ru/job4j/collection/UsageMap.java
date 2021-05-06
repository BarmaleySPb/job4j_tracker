package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("e.g.zakharov@gmail.com", "Zakharov Evgeny");
        map.put("vasyavasin@gmail.com", "Vasya Vasin");
        map.put("petyapetin@mail.ru", "Petya Petin");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
