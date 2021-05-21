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
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
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
        assertThat(persons.get(0).getName(), is("Vasiliy"));
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
        assertThat(persons.get(0).getSurname(), is("Ivanov"));
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
        assertThat(persons.get(0).getSurname(), is("Vasin"));
    }
}