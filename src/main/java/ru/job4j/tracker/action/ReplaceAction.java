package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;

public class ReplaceAction implements UserAction {

    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Replace item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("==== Edit item ====");
        int id = input.askInt("Enter ID: ");
        String itemsName = input.askStr("Enter name: ");
        if (tracker.replace(id, new Item(itemsName))) {
            out.println("Edit item is done.");
        } else {
            out.println("Item with ID: " + id + " not found.");
        }
        return true;
    }
}
