package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class RemoveDuplicatesFromSortedArray {

    /**
     * WHEN
     * numbers = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
     * THEN
     * returns [0, 1, 2, 3, 4]
     */
    @Test
    public void example1() {
        //given
        final var input = new Integer[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        //when
        final var index = solution(input);
        //then
        final var actual = stream(input).limit(index).collect(toList());
        final var expected = asList(0, 1, 2, 3, 4);
        assertEquals(expected, actual);
    }

    /**
     * WHEN
     * numbers = [1,1,2]
     * THEN
     * returns [1,2]
     */
    @Test
    public void example2() {
        //given
        final var input = new Integer[]{1, 1, 2};
        //when
        final var index = solution(input);
        //then
        final var actual = stream(input).limit(index).collect(toList());
        final var expected = asList(1, 2);
        assertEquals(expected, actual);
    }

    /**
     * WHEN
     * numbers = [1,1]
     * THEN
     * returns [1]
     */
    @Test
    public void example3() {
        //given
        final var input = new Integer[]{1, 1};
        //when
        final var index = solution(input);
        //then
        final var actual = stream(input).limit(index).collect(toList());
        final var expected = List.of(1);
        assertEquals(expected, actual);
    }

    private int solution(final Integer[] numbers) {
        var i = 0;
        var j = 1;
        while (i < numbers.length && j < numbers.length) {
            while (j < numbers.length - 1 && Objects.equals(numbers[j], numbers[i])) {
                j++;
            }
            numbers[i + 1] = numbers[j];
            i++;
            j++;
        }
        return i + 1;
    }
}
