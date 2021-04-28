package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Edit new item ====");
        int id = input.askInt("Enter ID: ");
        String itemsName = input.askStr("Enter name: ");
        if (tracker.replace(id, new Item(itemsName))) {
            System.out.println("Заявка успешно изменена.");
        } else {
            System.out.println("Заявка с ID: " + id + " не найдена");
        }
        return true;
    }
}
