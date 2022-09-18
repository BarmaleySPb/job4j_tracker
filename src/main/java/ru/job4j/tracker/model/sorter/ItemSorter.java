package ru.job4j.tracker.model.sorter;

import ru.job4j.tracker.model.Item;

import java.util.Collections;
import java.util.List;

public class ItemSorter {

    public static List<Item> sort(List<Item> items) {
        Collections.sort(items);
        return items;
    }

    public static List<Item> sortRevers(List<Item> items) {
        items.sort(Collections.reverseOrder());
        return items;
    }
}
