package ru.job4j.tracker;

import java.time.LocalDateTime;
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
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId() == id) {
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

    public Item[] findAll(Item[] items) {
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
        if (findById(id) != null) {
            int index = indexOf(id);
            int tempId = items[index].getId();
            items[index] = item;
            items[item.getId()].setId(tempId);
            return true;
        }
        return false;
    }

    public Item[] delete(int id) {
        int index = indexOf(id);
        int startPos = index + 1;
        int distPos = index;
        int length = size - index;
        items[size - 1] = null;
        size--;
        System.arraycopy(items, startPos, items, distPos, length);
        return items;
    }
}