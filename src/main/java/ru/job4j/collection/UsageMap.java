package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("e.g.zakharov@gmail.com", "Zakharov Evgeny");
        map.put("vasyavasin@gmail.com", "Vasya Vasin");
        map.put("petyapetin@mail.ru", "Petya Petin");
        for (Map.Entry<String, String> el : map.entrySet()) {
            System.out.println(el.getKey() + " = " + el.getValue());
        }
    }
}
