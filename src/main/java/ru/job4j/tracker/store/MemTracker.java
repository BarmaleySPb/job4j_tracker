package ru.job4j.tracker.store;

import ru.job4j.tracker.model.Item;

import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {
    private final ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;

    @Override
    public void init() {

    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
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

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    @Override
    public void findAllByReact(Observe<Item> observe) {
        items.forEach(observe::receive);
    }

    public boolean replace(int id, Item item) {
        int index = items.indexOf(findById(id));
        if (index != -1) {
            items.set(index, item);
            item.setId(id);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int index = items.indexOf(findById(id));
        if (index != -1) {
            items.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public void close() throws Exception {

    }
}