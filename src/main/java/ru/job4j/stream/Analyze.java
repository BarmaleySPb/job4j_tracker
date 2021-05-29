package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .getAsDouble();
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects().stream()
                .mapToInt(Subject::getScore)
                .average()
                .getAsDouble()))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(
                        Collectors.groupingBy(Subject::getName,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                        .stream().map(subj -> new Tuple(subj.getKey(), subj.getValue()))
                        .sorted(Comparator.comparing(Tuple::getName))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects().stream()
                .mapToInt(Subject::getScore)
                .sum()))
                .max((tuple1, tuple2) -> tuple1.getScore() > tuple2.getScore() ? 1 : -1).get();
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(
                        Collectors.groupingBy(Subject::getName,
                                Collectors.summingInt(Subject::getScore)))
                .entrySet()
                .stream().map(subj -> new Tuple(subj.getKey(), subj.getValue()))
                .max((tuple1, tuple2) -> tuple1.getScore() > tuple2.getScore() ? 1 : -1).get();
    }
}