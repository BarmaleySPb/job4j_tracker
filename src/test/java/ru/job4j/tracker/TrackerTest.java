package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker tracker = new MemTracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertEquals(result.getName(), item.getName());
    }

    @Test
    public void whenReplace() {
        MemTracker tracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertEquals(tracker.findById(id).getName(), "Bug with description");
    }

    @Test
    public void whenDelete() {
        MemTracker tracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertNull(tracker.findById(id));
    }

    @Test
    public void whenDelete3() {
        MemTracker tracker = new MemTracker();
        Item bug = new Item();
        Item ass = new Item();
        Item asd = new Item();
        bug.setName("Bug");
        ass.setName("ass");
        asd.setName("asd");
        tracker.add(bug);
        tracker.add(ass);
        tracker.add(asd);
        int id = bug.getId();
        tracker.delete(id);
        assertNull(tracker.findById(id));
    }

    @Test
    public void sortt() {
        MemTracker tracker = new MemTracker();
        Item first = new Item("first");
        Item second = new Item("second");
        Item third = new Item("third");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        List<Item> items = new ArrayList<>(tracker.findAll());
        Assert.assertEquals(ItemSorter.sort(items).toString(), "[" + first + ", "
                + second + ", " + third + "]");
        Assert.assertEquals(ItemSorter.sortRevers(items).toString(), "[" + third + ", "
                + second + ", " + first + "]");
    }
}