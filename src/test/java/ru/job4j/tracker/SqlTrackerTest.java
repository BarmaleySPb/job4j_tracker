package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.SqlTracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class
                .getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection
                .prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertEquals(item, tracker.findById(item.getId()));
    }

    @Test
    public void whenSaveItemAndFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        List<Item> items = new ArrayList<>();
        items.add(item);
        tracker.add(item);
        assertEquals(items, tracker.findByName(item.getName()));
    }

    @Test
    public void whenSaveItemsAndFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item firstItem = new Item("first");
        Item secondItem = new Item("second");
        Item thirdItem = new Item("third");
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        List<Item> items = new ArrayList<>();
        items.add(firstItem);
        items.add(secondItem);
        items.add(thirdItem);
        assertEquals(items, tracker.findAll());
    }

    @Test
    public void whenSaveItemAndReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item newItem = new Item("new");
        tracker.add(item);
        int id = item.getId();
        tracker.replace(item.getId(), newItem);
        assertEquals(newItem.getName(), tracker.findById(id).getName());
    }

    @Test
    public void whenSaveItemAndDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        int id = item.getId();
        tracker.delete(id);
        assertNull(tracker.findById(id));
    }
}