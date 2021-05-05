package ru.job4j.tracker;

import java.util.ArrayList;

public class ShowAllAction implements UserAction {

    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("==== All items ====");
        ArrayList<Item> arrayItems = tracker.findAll();
        if (arrayItems.size() > 0) {
            for (Item items : arrayItems) {
                out.println(items);
            }
        } else {
            out.println("Хранилище еще не содержит заявок.");
        }
        return true;
    }
}
