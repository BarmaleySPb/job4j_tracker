package ru.job4j.tracker;

import java.util.ArrayList;

public final class SingleTracker {

    private static Tracker tracker = null;

    private SingleTracker() {
    }

    public static Tracker getTracker() {
        if (tracker == null) {
            tracker = new Tracker();
        }
        return tracker;
    }

    public void add(Item item) {
        tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public ArrayList<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public ArrayList<Item> findAll() {
        return tracker.findAll();
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}