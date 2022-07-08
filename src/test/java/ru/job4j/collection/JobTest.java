package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertTrue;

public class JobTest {

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(
                new JobDescByPriority()
        );
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertTrue(rsl > 0);
    }

    @Test
    public void whenCompatorByName() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertTrue(rsl > 0);
    }

    @Test
    public void whenCompatorByPriority() {
        Comparator<Job> cmpPriority = new JobDescByPriority();
        int rsl = cmpPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertTrue(rsl > 0);
    }

    @Test
    public void whenCompatorByNameR() {
        Comparator<Job> cmpNameR = new JobDescByNameR();
        int rsl = cmpNameR.compare(
                new Job("Impl ask", 0),
                new Job("Fix bug", 1)
        );
        assertTrue(rsl < 0);
    }

    @Test
    public void whenCompatorByPriorityR() {
        Comparator<Job> cmpPriorityR = new JobDescByPriorityR();
        int rsl = cmpPriorityR.compare(
                new Job("Impl ask", 0),
                new Job("Fix bug", 1)
        );
        assertTrue(rsl < 0);
    }

    @Test
    public void whenCompatorByNameRAndProrityR() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(
                new JobDescByPriority()
        );
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertTrue(rsl > 0);
    }
}