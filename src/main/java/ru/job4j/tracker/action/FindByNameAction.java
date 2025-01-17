package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;

import java.util.List;

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
    public boolean execute(Input input, Store tracker) {
        out.println("==== Find items by name ====");
        String itemName = input.askStr("Enter name: ");
        List<Item> findItems = tracker.findByName(itemName);
        if (!findItems.isEmpty()) {
            for (Item items : findItems) {
                out.println(items);
            }
        } else {
            out.println("Items with name: " + itemName + " not found");
        }
        return true;
    }
}
