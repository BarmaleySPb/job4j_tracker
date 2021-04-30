package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Select: ");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Select: ");
        assertThat(selected, is(1));
    }

    @Test
    public void whenLotValidInput() {
        Output out = new StubOutput();
        String[] array = {"1", "3", "6", "2"};
        Input in = new StubInput(array);
        for (String s : array) {
            ValidateInput input = new ValidateInput(out, in);
            int selected = input.askInt("Select: ");
            assertThat(selected, is(Integer.valueOf(s)));
        }
    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-2", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Select: ");
        assertThat(selected, is(1));
    }
}