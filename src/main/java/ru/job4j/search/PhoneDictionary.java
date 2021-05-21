package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> name = p -> p.getName().equals(key);
        Predicate<Person> surName = p -> p.getSurname().equals(key);
        Predicate<Person> address = p -> p.getAddress().equals(key);
        Predicate<Person> phone = p -> p.getPhone().equals(key);
        Predicate<Person> combine = name.or(surName.or(phone.or(address)));
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
