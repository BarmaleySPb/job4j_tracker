package ru.job4j.collection;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {

    @Test
    public void whenMissed() {
        List<String> input = List.of("k1/sk1", "k2", "k2/sk1/sk2/sk3");
        List<String> expect = List.of("k1", "k1/sk1", "k2", "k2/sk1", "k2/sk1/sk2",
                "k2/sk1/sk2/sk3");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = List.of("k1", "k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void sortDesc() {
        List<String> input = List.of("k2/sk1/sk2/sk3", "k4/sk1", "k1/sk1", "k2",
                "k2/sk1/sk2/sk5");
        input = Departments.fillGaps(input);
        Departments.sortDesc(input);
        List<String> expected = List.of("k4", "k4/sk1", "k2", "k2/sk1", "k2/sk1/sk2",
                "k2/sk1/sk2/sk3", "k2/sk1/sk2/sk5", "k1", "k1/sk1");
        assertThat(input, is(expected));
    }

    @Test
    public void sortAsc() {
        List<String> input = List.of("k2/sk1/sk2/sk3", "k4/sk1", "k1/sk1", "k2",
                "k2/sk1/sk2/sk5");
        input = Departments.fillGaps(input);
        Departments.sortAsc(input);
        List<String> expected = List.of("k1", "k1/sk1", "k2", "k2/sk1", "k2/sk1/sk2",
                "k2/sk1/sk2/sk3", "k2/sk1/sk2/sk5", "k4", "k4/sk1");
        assertThat(input, is(expected));
    }
}