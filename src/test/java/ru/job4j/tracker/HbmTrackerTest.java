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
        assertEquals(1, items.size());
        assertEquals("item", items.get(0).getName());
    }

    @Test
    public void whenReplaceItem() {
        Store store = new HbmTracker();
        int idForReplace = store.add(new Item("item")).getId();
        Item replaceItem = new Item("replace Item");
        store.replace(idForReplace, replaceItem);
        assertEquals("replace Item", store.findById(idForReplace).getName());
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
        assertEquals(List.of(firstItem, secondItem), store.findAll());
    }

    @Test
    public void whenFindByName() {
        Store store = new HbmTracker();
        Item firstItem = store.add(new Item("first item"));
        Item secondItem = store.add(new Item("second item"));
        Item thirdItem = store.add(
                new Item("second item", Timestamp.from(Instant.now()), "description")
        );
        assertEquals(List.of(secondItem, thirdItem), store.findByName("second item"));
    }

    @Test
    public void whenFindById() {
        Store store = new HbmTracker();
        Item firstItem = store.add(new Item("first item"));
        Item secondItem = store.add(new Item("second item"));
        Item thirdItem = store.add(
                new Item("second item", Timestamp.from(Instant.now()), "description")
        );
        assertEquals(secondItem, store.findById(2));
    }
}