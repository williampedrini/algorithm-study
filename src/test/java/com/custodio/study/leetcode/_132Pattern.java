package com.custodio.study.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @see <a href="https://leetcode.com/problems/132-pattern/">Leet Code</a>
 */
public class _132Pattern {

    @Test
    public void example1() {
        //given
        final var numbers = new int[]{1, 2, 3, 4};
        //when
        final var actual = solution(numbers);
        //then
        assertFalse(actual);
    }

    @Test
    public void example2() {
        //given
        final var numbers = new int[]{3, 1, 4, 2};
        //when
        final var actual = solution(numbers);
        //then
        assertTrue(actual);
    }

    @Test
    public void example3() {
        //given
        final var numbers = new int[]{-1, 3, 2, 0};
        //when
        final var actual = solution(numbers);
        //then
        assertTrue(actual);
    }

    @Test
    public void example4() {
        //given
        final var numbers = new int[]{1, 0, 1, -4, -3};
        //when
        final var actual = solution(numbers);
        //then
        assertFalse(actual);
    }

    @Test
    public void example5() {
        //given
        final var numbers = new int[]{3, 5, 0, 3, 4};
        //when
        final var actual = solution(numbers);
        //then
        assertTrue(actual);
    }

    public boolean solution(final int[] numbers) {
        for (var index = 0; index + 2 < numbers.length; index++) {
            final var first = numbers[index];
            final var second = numbers[index + 1];
            final var third = numbers[index + 2];
            if (first < third && third < second) {
                return true;
            }
        }
        return false;
    }
}
