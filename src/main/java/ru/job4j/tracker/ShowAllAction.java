package ru.job4j.tracker;

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
    public boolean execute(Input input, Store tracker) {
        out.println("==== All items ====");
        if (!tracker.findAll().isEmpty()) {
            tracker.findAllByReact(out::println);
        } else {
            out.println("Хранилище еще не содержит заявок.");
        }
        return true;
    }
}
