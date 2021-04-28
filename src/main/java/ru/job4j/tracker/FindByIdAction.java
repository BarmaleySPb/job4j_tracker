package ru.job4j.tracker;

public class FindByIdAction implements UserAction {

    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Find item by ID ====");
        int id = input.askInt("Enter ID: ");
        Item find = tracker.findById(id);
        if (find != null) {
            System.out.println(find);
        } else {
            System.out.println("Заявка с ID: " + id + " не найдена");
        }
        return true;
    }
}
