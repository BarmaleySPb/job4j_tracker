package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertEquals(persons.get(0).getSurname(), "Arsentev");
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
        assertEquals(persons.get(0).getName(), "Vasiliy");
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
        assertEquals(persons.get(0).getSurname(), "Ivanov");
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
        assertEquals(persons.get(0).getSurname(), "Vasin");
    }
}