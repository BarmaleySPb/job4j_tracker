package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenMinusTwo() {
        int i = Fact.calc(-2);
    }

    @Test
    public void whenTwo() {
        int rsl = Fact.calc(2);
        assertEquals(2, rsl);
    }
}