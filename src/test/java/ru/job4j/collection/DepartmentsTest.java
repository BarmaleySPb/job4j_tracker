package ru.job4j.collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.collection.Departments.fillGaps;

public class DepartmentsTest {

    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1", "k2", "k2/sk1/sk2/sk3");
        List<String> expect = Arrays.asList("k1", "k1/sk1", "k2", "k2/sk1", "k2/sk1/sk2", "k2/sk1/sk2/sk3");
        List<String> result = fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void sortDesc() {
        List<String> input = Arrays.asList("k2/sk1/sk2/sk3", "k4/sk1", "k1/sk1", "k2", "k2/sk1/sk2/sk5");
        input = fillGaps(input);
        Departments.sortDesc(input);
        List<String> expected = Arrays.asList("k4", "k4/sk1", "k2", "k2/sk1", "k2/sk1/sk2", "k2/sk1/sk2/sk3",
                "k2/sk1/sk2/sk5", "k1", "k1/sk1");
        assertThat(input, is(expected));
    }

    @Test
    public void sortAsc() {
        List<String> input = Arrays.asList("k2/sk1/sk2/sk3", "k4/sk1", "k1/sk1", "k2", "k2/sk1/sk2/sk5");
        input = fillGaps(input);
        Departments.sortAsc(input);
        List<String> expected = Arrays.asList("k1", "k1/sk1", "k2", "k2/sk1", "k2/sk1/sk2",
                "k2/sk1/sk2/sk3", "k2/sk1/sk2/sk5", "k4", "k4/sk1");
        assertThat(input, is(expected));
    }
}