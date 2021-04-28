package ru.job4j.ex;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenMinusTwo() {
        Fact.calc(-2);
    }

    @Test
    public void whenTwo() {
        int rsl = Fact.calc(2);
        assertThat(rsl, is(2));
    }
}