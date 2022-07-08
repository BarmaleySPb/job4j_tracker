package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertEquals("Arsentev", persons.get(0).getSurname());
    }

    @Test
    public void whenFindNothin() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Vasiliy");
        assertTrue(persons.isEmpty());
    }

    @Test
    public void whenFindBySurname() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Vasiliy", "Vasin", "534800", "Moscow")
        );
        phones.add(
                new Person("Ivan", "Ivanow", "734872", "Murmansk")
        );
        var persons = phones.find("Vasin");
        assertEquals("Vasiliy", persons.get(0).getName());
    }

    @Test
    public void whenFindByPhone() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Vasiliy", "Vasin", "534800", "Moscow")
        );
        phones.add(
                new Person("Ivan", "Ivanov", "734872", "Murmansk")
        );
        var persons = phones.find("734872");
        assertEquals("Ivanov", persons.get(0).getSurname());
    }

    @Test
    public void whenFindByAddress() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Vasiliy", "Vasin", "534800", "Moscow")
        );
        phones.add(
                new Person("Ivan", "Ivanow", "734872", "Murmansk")
        );
        var persons = phones.find("Moscow");
        assertEquals("Vasin", persons.get(0).getSurname());
    }
}