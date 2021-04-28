package ru.job4j.tracker;

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
        System.out.println("==== Find items by name ====");
        String itemName = input.askStr("Enter name: ");
        Item[] findItems = tracker.findByName(itemName);
        if (findItems.length > 0) {
            for (Item items : findItems) {
                System.out.println(items);
            }
        } else {
            System.out.println("Заявки с именем: " + itemName + " не найдены");
        }
        return true;
    }
}
