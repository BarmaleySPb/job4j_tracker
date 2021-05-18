package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Students {

    public static Map<String, Student> convertToMap(List<Student> students) {
        return students.stream()
                .distinct()
                .collect(Collectors.toMap(
                        e -> e.getSurname(),
                        e -> e
                ));

    }
}
