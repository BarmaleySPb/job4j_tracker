package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;

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
            out.println("The repository does not contain requests yet.");
        }
        return true;
    }
}
