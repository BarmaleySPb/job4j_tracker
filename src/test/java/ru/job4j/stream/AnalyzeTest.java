package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class AnalyzeTest {

    @Test
    public void whenSinglePupil() {
        double average = Analyze.averageScore(
                Stream.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100)))
                )
        );
        assertEquals((Double) average, (Double) 100D);
    }

    @Test
    public void whenPupilAverage() {
        double average = Analyze.averageScore(
                Stream.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60)))
                )
        );
        assertEquals((Double) average, (Double) 80D);
    }

    @Test
    public void whenListOfPupilAverage() {
        List<Tuple> average = Analyze.averageScoreByPupil(
                Stream.of(
                        new Pupil("Ivanov", List.of(
                                new Subject("Math", 100),
                                new Subject("Lang", 100)
                        )),
                        new Pupil("Petrov", List.of(
                                new Subject("Math", 60),
                                new Subject("Lang", 60)
                        ))
                )
        );
        assertEquals(average, List.of(
                new Tuple("Ivanov", 100D),
                new Tuple("Petrov", 60D)
        ));
    }

    @Test
    public void whenListOfSubjectAverage() {
        List<Tuple> average = Analyze.averageScoreBySubject(
                Stream.of(
                        new Pupil("Ivanov", List.of(
                                new Subject("Math", 100),
                                new Subject("Lang", 100)
                        )),
                        new Pupil("Petrov", List.of(
                                new Subject("Math", 60),
                                new Subject("Lang", 60)
                        ))
                )
        );
        assertEquals(average, List.of(
                new Tuple("Math", 80D),
                new Tuple("Lang", 80D)
        ));
    }

    @Test
    public void whenBestPupil() {
        Tuple best = Analyze.bestStudent(
                Stream.of(
                        new Pupil("Ivanov", List.of(
                                new Subject("Math", 100),
                                new Subject("Lang", 100)
                        )),
                        new Pupil("Petrov", List.of(
                                new Subject("Math", 60),
                                new Subject("Lang", 60)
                        ))
                )
        );
        assertEquals(best, new Tuple("Ivanov", 200D));
    }

    @Test
    public void whenBestSubject() {
        Tuple best = Analyze.bestSubject(
                Stream.of(
                        new Pupil("Ivanov", List.of(
                                new Subject("Math", 100),
                                new Subject("Lang", 40)
                        )),
                        new Pupil("Petrov", List.of(
                                new Subject("Math", 60),
                                new Subject("Lang", 60)
                        ))
                )
        );
        assertEquals(best, new Tuple("Math", 160D));
    }
}