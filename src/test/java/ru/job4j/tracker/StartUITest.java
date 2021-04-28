package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Replaced name", "1", "1", "New item name", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ReplaceAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(1).getName(), is("New item name"));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Deleted item", "1", "1", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new DeleteAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(1), is(nullValue()));
    }

    @Test
    public void whenShowAll() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "first", "0", "second", "0", "third", "1", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ShowAllAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        Item[] items = tracker.findAll();
        Assert.assertThat(3, is(items.length));
    }

    @Test
    public void whenFindById() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "first", "0", "second", "0", "third", "1", "2", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new FindByIdAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        //Item findItem = tracker.findById(2);
        Assert.assertThat(tracker.findById(2).getName(), is("second"));
    }

    @Test
    public void whenFindByName() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "first", "0", "second", "0", "first", "1", "first", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new FindByNameAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        Item[] findItem = tracker.findByName("first");
        Assert.assertThat(2, is(findItem.length));
    }

}