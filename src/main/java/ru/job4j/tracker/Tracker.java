package ru.job4j.tracker;

import java.util.ArrayList;

public class Tracker {
    private final ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;

    public void add(Item item) {
        items.add(item);
        item.setId(ids++);
    }

    public Item findById(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().contains(key)) {
                result.add(item);
            }
        }
        return result;
    }

    public ArrayList<Item> findAll() {
        return items;
    }

    public boolean replace(int id, Item item) {
        for (Item itemF : items) {
            if (itemF.getId() == id) {
                itemF.setName(item.getName());
                itemF.setCreated(item.getCreated());
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        return findById(id) != null && items.remove(findById(id));
    }
}