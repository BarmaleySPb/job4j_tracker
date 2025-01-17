package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArrayToListTest {

    @Test
    public void twoDimArray() {
        Integer[][] array = {
                {1, 2, 2},
                {4, 5},
                {7, 8, 9},
                {11}
        };
        List<Integer> expected = List.of(1, 2, 2, 4, 5, 7, 8, 9, 11);
        assertEquals(expected, ArrayToList.twoDimArray(array));
    }

    @Test
    public void twoDimArray2() {
        Integer[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        assertEquals(expected, ArrayToList.twoDimArray(array));
    }
}