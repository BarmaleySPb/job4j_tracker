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
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                result = i;
                break;
            }
        }
        return result;
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
        return Arrays.copyOf(newArray, counter);
    }

    public Item[] findAll() {
        Item[] newArray = new Item[size];
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                newArray[counter] = items[i];
                counter++;
            }
        }
        return Arrays.copyOf(newArray, size);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            int tempId = items[index].getId();
            items[index] = item;
            items[index].setId(tempId);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
            return true;
        }
        return false;
    }
}