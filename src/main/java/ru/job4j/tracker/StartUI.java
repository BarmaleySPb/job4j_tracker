package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("==== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            }
            if (select == 1) {
                System.out.println("==== All items ====");
                Item[] arrayItems = tracker.findAll(); //check
                if (arrayItems.length != 0) {
                    for (Item items : arrayItems) {
                        System.out.println(items.toString());
                    }
                } else {
                    System.out.println("Заявки отсутствуют.");
                }
            }
            if (select == 2) {
                System.out.println("==== Edit new item ====");
                System.out.print("Enter ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter item's name: ");
                String itemsName = scanner.nextLine();
                if (tracker.replace(id, new Item(itemsName))) {
                    System.out.println("Заявка успешно изменена.");
                } else {
                    System.out.println("Заявка с ID: " + id + " не найдена");
                }
            }
            if (select == 3) {
                System.out.println("==== Delete item ====");
                System.out.print("Enter ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Заявка успешно удалена.");
                } else {
                    System.out.println("Заявка с таким ID не найдена.");
                }
            }
            if (select == 4) {
                System.out.println("==== Find item by ID ====");
                System.out.print("Enter ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.findById(id) != null) {
                    System.out.println(tracker.findById(id).toString());
                } else {
                    System.out.println("Заявка с таким ID не найдена");
                }
            }
            if (select == 5) {
                System.out.println("==== Find items by name ====");
                System.out.print("Enter name of item: ");
                String itemName = scanner.nextLine();
                Item[] findItems = tracker.findByName(itemName);
                if (findItems.length != 0) {
                    for (Item items : findItems) {
                        System.out.println(items.toString());
                    }
                } else {
                    System.out.println("Заявки с таким именем не найдены");
                }
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}