package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentsTest {

    @Test
    public void convertToMap() {
        List<Student> students = List.of(
                new Student(20, "Surname2"),
                new Student(30, "Surname3"),
                new Student(30, "Surname3"),
                new Student(50, "Surname5"),
                new Student(50, "Surname5"),
                new Student(60, "Surname6"),
                new Student(80, "Surname8"),
                new Student(90, "Surname8")
        );
        Map<String, Student> result = Students.convertToMap(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Surname2", students.get(0));
        expected.put("Surname3", students.get(1));
        expected.put("Surname5", students.get(3));
        expected.put("Surname6", students.get(5));
        expected.put("Surname8", students.get(6));
        assertThat(result, is(expected));
    }
}