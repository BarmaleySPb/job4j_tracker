package ru.job4j.tracker;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import static org.junit.Assert.*;

public class HbmTrackerTest {

    @Test
    public void whenAddItem() {
        Store store = new HbmTracker();
        store.add(new Item("item"));
        List<Item> items = store.findAll();
        assertEquals(items.size(), 1);
        assertEquals(items.get(0).getName(), "item");
    }

    @Test
    public void whenReplaceItem() {
        Store store = new HbmTracker();
        int idForReplace = store.add(new Item("item")).getId();
        Item replaceItem = new Item("replace Item");
        store.replace(idForReplace, replaceItem);
        assertEquals(store.findById(idForReplace).getName(), "replace Item");
    }

    @Test
    public void whenDeleteItem() {
        Store store = new HbmTracker();
        int id = store.add(new Item("item")).getId();
        store.delete(id);
        assertTrue(store.findAll().isEmpty());
    }

    @Test
    public void whenDeleteItemThenFalse() {
        Store store = new HbmTracker();
        store.add(new Item("item"));
        assertFalse(store.delete(2));
    }

    @Test
    public void whenFindAll() {
        Store store = new HbmTracker();
        Item firstItem = store.add(new Item("first item"));
        Item secondItem = store.add(new Item("second item"));
        assertEquals(store.findAll(), List.of(firstItem, secondItem));
    }

    @Test
    public void whenFindByName() {
        Store store = new HbmTracker();
        Item firstItem = store.add(new Item("first item"));
        Item secondItem = store.add(new Item("second item"));
        Item thirdItem = store.add(
                new Item("second item", Timestamp.from(Instant.now()), "description")
        );
        assertEquals(store.findByName("second item"), List.of(secondItem, thirdItem));
    }

    @Test
    public void whenFindById() {
        Store store = new HbmTracker();
        Item firstItem = store.add(new Item("first item"));
        Item secondItem = store.add(new Item("second item"));
        Item thirdItem = store.add(
                new Item("second item", Timestamp.from(Instant.now()), "description")
        );
        assertEquals(store.findById(2), secondItem);
    }
}