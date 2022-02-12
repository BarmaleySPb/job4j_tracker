package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StudentLevelTest {

    @Test
    public void whenSorted() {
        List<Student> input = new ArrayList<>();
        input.add(new Student(129, "Pety"));
        input.add(new Student(35, "Masha"));
        input.add(new Student(28, "Makha"));
        List<Student> expected = List.of(
                new Student(28, "Makha"),
                new Student(35, "Masha"),
                new Student(129, "Pety")
        );
        assertEquals(StudentLevel.levelOf(input, 20), expected);
    }

    @Test
    public void whenOnlyNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        List<Student> expected = List.of();
        assertEquals(StudentLevel.levelOf(input, 100), expected);
    }

    @Test
    public void whenHasNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        input.add(new Student(28, "Pety"));
        List<Student> expected = List.of(new Student(28, "Pety"));
        assertEquals(StudentLevel.levelOf(input, 10), expected);
    }
}