package ru.job4j.tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.DeleteAction;
import ru.job4j.tracker.action.FindByIdAction;
import ru.job4j.tracker.action.FindByNameAction;
import ru.job4j.tracker.action.ReplaceAction;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import ru.job4j.tracker.store.HbmTracker;
import ru.job4j.tracker.store.Store;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HbmTrackerTest {

    private static Store tracker;

    @BeforeEach
    public void init() {
        tracker = new HbmTracker();
    }

    @Test
    void whenAddItem() {
        tracker.add(new Item("item"));
        List<Item> items = tracker.findAll();
        assertThat(items).hasSize(1);
        assertThat(items.get(0).getName()).isEqualTo("item");
    }

    @Test
    void whenReplaceItem() {
        int idForReplace = tracker.add(new Item("item")).getId();
        Item replaceItem = new Item("replace Item");
        tracker.replace(idForReplace, replaceItem);
        assertThat(tracker.findById(idForReplace).getName()).isEqualTo("replace Item");
    }

    @Test
    void whenDeleteItem() {
        int id = tracker.add(new Item("item")).getId();
        tracker.delete(id);
        assertThat(tracker.findAll()).isEmpty();
    }

    @Test
    void whenDeleteItemThenFalse() {
        tracker.add(new Item("item"));
        assertThat(tracker.delete(2)).isFalse();
    }

    @Test
    void whenFindAll() {
        Item firstItem = tracker.add(new Item("first item"));
        Item secondItem = tracker.add(new Item("second item"));
        assertThat(tracker.findAll()).isEqualTo(List.of(firstItem, secondItem));
    }

    @Test
    void whenFindByName() {
        Item firstItem = tracker.add(new Item("first item"));
        Item secondItem = tracker.add(new Item("second item"));
        Item thirdItem = tracker.add(new Item("second item"));
        assertThat(tracker.findByName("second item")).isEqualTo(List.of(secondItem, thirdItem));
    }

    @Test
    void whenFindById() {
        Item firstItem = tracker.add(new Item("first item"));
        Item secondItem = tracker.add(new Item("second item"));
        Item thirdItem = tracker.add(new Item("second item"));
        assertThat(tracker.findById(2)).isEqualTo(secondItem);
    }

    @Test
    void whenReplaceItemWithMock() {
        Output out = new StubOutput();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction rep = new ReplaceAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        String expected = out.toString();
        assertThat(expected).isEqualTo("==== Edit item ====" + ln + "Edit item is done." + ln);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenDeleteItemWithMock() {
        Output out = new StubOutput();
        tracker.add(new Item("Item for delete"));
        DeleteAction delete = new DeleteAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        delete.execute(input, tracker);

        String ln = System.lineSeparator();
        String expected = out.toString();
        assertThat(expected).isEqualTo("==== Delete item ====" + ln + "Item deleted." + ln);
        assertThat(tracker.findById(1)).isNull();
        assertThat(tracker.findAll()).isEmpty();
    }

    @Test
    void whenFindByIdWithMock() {
        Output out = new StubOutput();
        Item item = new Item("Item for find");
        tracker.add(item);
        FindByIdAction findById = new FindByIdAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        findById.execute(input, tracker);

        String ln = System.lineSeparator();
        String expected = out.toString();
        assertThat(expected).isEqualTo("==== Find item by ID ====" + ln + item + ln);
        assertThat(tracker.findById(1)).isEqualTo(item);
    }

    @Test
    void whenFindByNameWithMock() {
        Output out = new StubOutput();
        Item firstItem = new Item("firstItem");
        Item secondItem = new Item("secondItem");
        Item thirdItem = new Item("secondItem");
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        FindByNameAction findById = new FindByNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("secondItem");

        findById.execute(input, tracker);

        String ln = System.lineSeparator();
        String expected = out.toString();
        assertThat(expected).isEqualTo(
                "==== Find items by name ====" + ln + secondItem + ln + thirdItem + ln
        );
    }
}