package ru.job4j.tracker;

import java.util.ArrayList;

public class FindByNameAction implements UserAction {

    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("==== Find items by name ====");
        String itemName = input.askStr("Enter name: ");
     //   Item[] findItems = tracker.findByName(itemName);
        ArrayList<Item> findItems = tracker.findByName(itemName);
        if (findItems.size() > 0) {
            for (Item items : findItems) {
                out.println(items);
            }
        } else {
            out.println("Заявки с именем: " + itemName + " не найдены");
        }
        return true;
    }
}
