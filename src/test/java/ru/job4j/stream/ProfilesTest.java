package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collect() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Lenina", 12, 23)),
                new Profile(new Address("St. Peterbyrg", "Novikova", 122, 423)),
                new Profile(new Address("Moscow", "Vtoraya sov", 62, 255))
                );
        List<Address> result = Profiles.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Moscow", "Lenina", 12, 23));
        expected.add(new Address("Moscow", "Vtoraya sov", 62, 255));
        expected.add(new Address("St. Peterbyrg", "Novikova", 122, 423));
        assertThat(result, is(expected));
    }

    @Test
    public void collectWhenDoubleAddress() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Lenina", 12, 23)),
                new Profile(new Address("Moscow", "Lenina", 12, 23)),
                new Profile(new Address("St. Peterbyrg", "Novikova", 122, 423)),
                new Profile(new Address("St. Peterbyrg", "Novikova", 122, 423)),
                new Profile(new Address("Moscow", "Vtoraya sov", 62, 255))
        );
        List<Address> result = Profiles.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Moscow", "Lenina", 12, 23));
        expected.add(new Address("Moscow", "Vtoraya sov", 62, 255));
        expected.add(new Address("St. Peterbyrg", "Novikova", 122, 423));
        assertThat(result, is(expected));
    }
}