package ru.job4j.tracker;

public class ShowAllAction implements UserAction {

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== All items ====");
        Item[] arrayItems = tracker.findAll();
        if (arrayItems.length > 0) {
            for (Item items : arrayItems) {
                System.out.println(items);
            }
        } else {
            System.out.println("Хранилище еще не содержит заявок.");
        }
        return true;
    }
}
