package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import ru.job4j.tracker.store.MemTracker;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StartUITest {

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        MemTracker tracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
                actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertEquals(
                "Menu." + System.lineSeparator() + "0. Exit program" + System.lineSeparator(),
                out.toString()
        );
    }

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "new", "1"}
        );
        MemTracker tracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
                actions.add(new CreateAction(out));
                actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        List<Item> findItem = tracker.findAll();
        Item newItem = findItem.get(0);
        assertEquals(
                "Menu." + System.lineSeparator()
                        + "0. Add new Item" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        + "==== Create a new Item ====" + System.lineSeparator()
                        + "Added new item: " + newItem + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Add new Item" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator(),
                out.toString()
        );
    }

    @Test
    public void whenReplaceItem() {
        MemTracker tracker = new MemTracker();
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
        assertEquals(
                "Menu." + System.lineSeparator()
                        + "0. Replace item" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        + "==== Edit item ====" + System.lineSeparator()
                        + "Edit item is done." + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Replace item" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator(),
                out.toString()
        );
    }

    @Test
    public void whenShowAll() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        MemTracker tracker = new MemTracker();
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
        assertEquals(
                "Menu." + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        + "==== All items ====" + System.lineSeparator()
                        + first + System.lineSeparator()
                        + second + System.lineSeparator()
                        + third + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator(),
                out.toString()
        );
    }

    @Test
    public void whenFindById() {
        MemTracker tracker = new MemTracker();
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
        assertEquals(
                "Menu." + System.lineSeparator()
                        + "0. Find item by ID" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        + "==== Find item by ID ====" + System.lineSeparator()
                        + newItem + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find item by ID" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator(),
                out.toString()
        );
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "second", "1"}
        );
        MemTracker tracker = new MemTracker();
        Item first = new Item("first");
        Item second = new Item("second");
        tracker.add(first);
        tracker.add(second);
        ArrayList<UserAction> actions = new ArrayList<>();
                actions.add(new FindByNameAction(out));
                actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertEquals(
                "Menu." + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        + "==== Find items by name ====" + System.lineSeparator()
                        + second + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator(),
                out.toString()
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        MemTracker tracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
                actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertEquals(
                "Menu." + ln
                        + "0. Exit program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit program" + ln,
                out.toString()
        );
    }

    @Test
    public void executeReplaceAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction rep = new ReplaceAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertEquals(out.toString(), "==== Edit item ====" + ln
                + "Edit item is done." + ln);
        assertEquals(replacedName, tracker.findAll().get(0).getName());
    }

    @Test
    public void executeReplaceAction2() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        ReplaceAction rep = new ReplaceAction(out);

        Input input = mock(Input.class);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertEquals(out.toString(), "==== Edit item ====" + ln
                + "Item with ID: 0 not found." + ln);
        assertEquals("Replaced item", tracker.findAll().get(0).getName());
    }

    @Test
    public void executeDeleteAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("New item"));
        DeleteAction del = new DeleteAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        del.execute(input, tracker);

        String ln = System.lineSeparator();
        assertEquals(
                "==== Delete item ====" + ln
                + "Item deleted." + ln,
                out.toString());
    }

    @Test
    public void executeDeleteAction2() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("New item"));
        DeleteAction del = new DeleteAction(out);

        Input input = mock(Input.class);

        del.execute(input, tracker);

        String ln = System.lineSeparator();
        assertEquals(
                "==== Delete item ====" + ln
                + "Item with ID: 0 not found." + ln,
                out.toString()
        );
    }

    @Test
    public void executeFindByIdAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item firstItem = new Item("First item");
        Item secondItem = new Item("Second item");
        Item thirdItem = new Item("Third item");
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        FindByIdAction find = new FindByIdAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(2);

        find.execute(input, tracker);

        String ln = System.lineSeparator();
        assertEquals(
                "==== Find item by ID ===="
                + ln + secondItem + ln,
                out.toString()
        );
    }

    @Test
    public void executeFindByIdAction2() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item firstItem = new Item("First item");
        Item secondItem = new Item("Second item");
        Item thirdItem = new Item("Third item");
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        FindByIdAction find = new FindByIdAction(out);

        Input input = mock(Input.class);

        find.execute(input, tracker);

        String ln = System.lineSeparator();
        assertEquals(
                "==== Find item by ID ====" + ln
                + "Item with ID: 0 not found." + ln,
                out.toString()
        );
    }

    @Test
    public void executeFindByNameAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item firstItem = new Item("First item");
        Item secondItem = new Item("Second item");
        Item thirdItem = new Item("Third item");
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        FindByNameAction find = new FindByNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("Third item");

        find.execute(input, tracker);

        String ln = System.lineSeparator();
        assertEquals(
                "==== Find items by name ====" + ln
                + thirdItem + ln,
                out.toString()
        );
    }
}