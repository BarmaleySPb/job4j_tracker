package ru.job4j.tracker.store;

import ru.job4j.tracker.model.User;

public class UserStore {

    public static void main(String[] args) {
        User user = new User(1, "root", "root");
        System.out.println(user);
    }
}
