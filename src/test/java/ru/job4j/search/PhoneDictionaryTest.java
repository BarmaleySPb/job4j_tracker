package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindNothin() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Vasiliy");
        assertTrue(persons.isEmpty());
    }

    @Test
    public void whenFindBySurname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Vasiliy", "Vasin", "534800", "Moscow")
        );
        phones.add(
                new Person("Ivan", "Ivanow", "734872", "Murmansk")
        );
        ArrayList<Person> persons = phones.find("Vasin");
        assertThat(persons.get(0).getName(), is("Vasiliy"));
    }

    @Test
    public void whenFindByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Vasiliy", "Vasin", "534800", "Moscow")
        );
        phones.add(
                new Person("Ivan", "Ivanov", "734872", "Murmansk")
        );
        ArrayList<Person> persons = phones.find("734872");
        assertThat(persons.get(0).getSurname(), is("Ivanov"));
    }

    @Test
    public void whenFindByAddress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Vasiliy", "Vasin", "534800", "Moscow")
        );
        phones.add(
                new Person("Ivan", "Ivanow", "734872", "Murmansk")
        );
        ArrayList<Person> persons = phones.find("Moscow");
        assertThat(persons.get(0).getSurname(), is("Vasin"));
    }
}