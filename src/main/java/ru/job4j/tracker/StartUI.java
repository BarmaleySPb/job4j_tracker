package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item item = new Item();
        item.setName("First item");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        item.setCreated(LocalDateTime.now());
        System.out.println(item.getCreated().format(formatter));
        Tracker tracker = new Tracker();
        tracker.add(item);
        Item result = tracker.findById(1);
        System.out.println();
        System.out.println("search result: " + "\n" + result.getName() + "\n" + result.getId());
        System.out.println();
        System.out.println(item);
    }
}
