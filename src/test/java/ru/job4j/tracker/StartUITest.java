package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenCreateItem() {
        String name = "new";
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", name, "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        Item newItem = tracker.findById(1);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Add new Item" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        + "==== Create a new Item ====" + System.lineSeparator()
                        + "Добавлена новая заявка: " + newItem + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Add new Item" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item newItem = new Item("new");
        String newName = "replace";
        tracker.add(newItem);
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", String.valueOf(newItem.getId()), newName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Replace item" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        + "==== Edit new item ====" + System.lineSeparator()
                        + "Заявка успешно изменена." + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Replace item" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenShowAll() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Tracker tracker = new Tracker();
        Item first = new Item("first");
        Item second = new Item("second");
        Item third = new Item("third");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        UserAction[] actions = {
                new ShowAllAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        + "==== All items ====" + System.lineSeparator()
                        + first + System.lineSeparator()
                        + second + System.lineSeparator()
                        + third + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item newItem = new Item("new");
        tracker.add(newItem);
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", String.valueOf(newItem.getId()), "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        Item findItem = tracker.findById(newItem.getId());
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find item by ID" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        + "==== Find item by ID ====" + System.lineSeparator()
                        + findItem + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find item by ID" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "second", "1"}
        );
        Tracker tracker = new Tracker();
        Item first = new Item("first");
        Item second = new Item("second");
        tracker.add(first);
        tracker.add(second);
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        Item[] findItem = tracker.findByName(second.getName());
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        + "==== Find items by name ====" + System.lineSeparator()
                        + findItem[first.getId() - 1] + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
        ));
    }
}