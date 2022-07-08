package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    private Analyze() {

    }

    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElseThrow();
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects().stream()
                .mapToInt(Subject::getScore)
                .average()
                .orElseThrow()))
                .toList();
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(
                        Collectors.groupingBy(Subject::getName, LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                        .stream().map(subj -> new Tuple(subj.getKey(), subj.getValue()))
                .toList();
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects().stream()
                .mapToInt(Subject::getScore)
                .sum()))
                .max(Comparator.comparingDouble(Tuple::getScore)).orElseThrow();
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(
                        Collectors.groupingBy(Subject::getName,
                                Collectors.summingInt(Subject::getScore)))
                .entrySet()
                .stream().map(subj -> new Tuple(subj.getKey(), subj.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore)).orElseThrow();
    }
}