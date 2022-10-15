package com.custodio.study.neetcode.stack;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @see <a href="https://leetcode.com/problems/daily-temperatures/">Neet Code</a>
 */
public class DailyTemperatures {

    @Test
    public void example1() {
        //given
        final var temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        //when
        final var actual = solution(temperatures);
        //then
        final var expected = new int[]{1, 1, 4, 2, 1, 1, 0, 0};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void example2() {
        //given
        final var temperatures = new int[]{30, 40, 50, 60};
        //when
        final var actual = solution(temperatures);
        //then
        final var expected = new int[]{1, 1, 1, 0};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void example3() {
        //given
        final var temperatures = new int[]{30, 60, 90};
        //when
        final var actual = solution(temperatures);
        //then
        final var expected = new int[]{1, 1, 0};
        assertArrayEquals(expected, actual);
    }

    public int[] solution(final int[] temperatures) {
        return null;
    }
}
