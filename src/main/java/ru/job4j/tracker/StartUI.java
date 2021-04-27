package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавлена новая заявка: " + item);
    }

    public static void showAllItem(Input input, Tracker tracker) {
        System.out.println("==== All items ====");
        Item[] arrayItems = tracker.findAll();
        if (arrayItems.length > 0) {
            for (Item items : arrayItems) {
                System.out.println(items);
            }
        } else {
            System.out.println("Хранилище еще не содержит заявок.");
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("==== Edit new item ====");
        int id = input.askInt("Enter ID: ");
        String itemsName = input.askStr("Enter name: ");
        if (tracker.replace(id, new Item(itemsName))) {
            System.out.println("Заявка успешно изменена.");
        } else {
            System.out.println("Заявка с ID: " + id + " не найдена");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("==== Delete item ====");
        int id = input.askInt("Enter ID: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка успешно удалена.");
        } else {
            System.out.println("Заявка с ID: " + id + " не найдена.");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("==== Find item by ID ====");
        int id = input.askInt("Enter ID: ");
        Item find = tracker.findById(id);
        if (find != null) {
            System.out.println(find);
        } else {
            System.out.println("Заявка с ID: " + id + " не найдена");
        }
    }

    public static void findItemsByName(Input input, Tracker tracker) {
        System.out.println("==== Find items by name ====");
        String itemName = input.askStr("Enter name: ");
        Item[] findItems = tracker.findByName(itemName);
        if (findItems.length > 0) {
            for (Item items : findItems) {
                System.out.println(items);
            }
        } else {
            System.out.println("Заявки с именем: " + itemName + " не найдены");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            }
            if (select == 1) {
                StartUI.showAllItem(input, tracker);
            }
            if (select == 2) {
                StartUI.replaceItem(input, tracker);
            }
            if (select == 3) {
                StartUI.deleteItem(input, tracker);
            }
            if (select == 4) {
                StartUI.findItemById(input, tracker);
            }
            if (select == 5) {
                StartUI.findItemsByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
            if (select < 0 || select > 6) {
                System.out.println("Введено недопустимое значение!!!");
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}