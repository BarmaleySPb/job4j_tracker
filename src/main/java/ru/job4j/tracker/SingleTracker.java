package ru.job4j.tracker;

public final class SingleTracker {

    private Tracker tracker = new Tracker();

    public void add(Item item) {
        tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}