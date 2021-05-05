package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

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
        ArrayList<UserAction> actions = new ArrayList<>();
                actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "new", "1"}
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
                actions.add(new CreateAction(out));
                actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        ArrayList<Item> findItem = tracker.findAll();
        Item newItem = findItem.get(0); //tracker.findAll()[0];
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
        ArrayList<UserAction> actions = new ArrayList<>();
                actions.add(new ReplaceAction(out));
                actions.add(new ExitAction(out));
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
        ArrayList<UserAction> actions = new ArrayList<>();
                actions.add(new ShowAllAction(out));
                actions.add(new ExitAction(out));
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
        ArrayList<UserAction> actions = new ArrayList<>();
                actions.add(new FindByIdAction(out));
                actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find item by ID" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        + "==== Find item by ID ====" + System.lineSeparator()
                        + newItem + System.lineSeparator()
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
        ArrayList<UserAction> actions = new ArrayList<>();
                actions.add(new FindByNameAction(out));
                actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        + "==== Find items by name ====" + System.lineSeparator()
                        + second + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"/* Пункты меню: неверный, верный. */}
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
                actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit program" + ln
                )
        );
    }
}