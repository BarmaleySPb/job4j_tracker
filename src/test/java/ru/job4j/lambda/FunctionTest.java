package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Functions.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D, 17D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadFunction() {
        List<Double> result = Functions.diapason(3, 7, x -> x * x + 2 * x - 1);
        List<Double> expected = Arrays.asList(14D, 23D, 34D, 47D, 62D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExpoFunction() {
        List<Double> result = Functions.diapason(2, 9, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(4D, 8D, 16D, 32D, 64D, 128D, 256D, 512D);
        assertThat(result, is(expected));
    }

}