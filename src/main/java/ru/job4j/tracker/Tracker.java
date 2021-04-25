package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] newArray = new Item[items.length];
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (key.equals(items[i].getName())) {
                newArray[counter] = items[i];
                counter++;
            }
        }
        newArray = Arrays.copyOf(newArray, counter);
        return newArray;
    }

    public Item[] findAll(Item[] items) {
        Item[] newArray = new Item[size];
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                newArray[counter] = items[i];
                counter++;
            }
        }
        items = Arrays.copyOf(newArray, size);
        return items;
    }
}