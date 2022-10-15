package com.custodio.study.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/climbing-stairs/">Leet Code</a>
 */
public class ClimbingStairs {

    /**
     * WHEN
     * number = 2
     * THEN
     * returns 2
     */
    @Test
    public void example1() {
        //given
        final var number = 2;
        //when
        final var actual = solution(number);
        //then
        final var expected = 2;
        assertEquals(expected, actual);
    }

    /**
     * WHEN
     * number = 3
     * THEN
     * returns 3
     */
    @Test
    public void example2() {
        //given
        final var number = 3;
        //when
        final var actual = solution(number);
        //then
        final var expected = 3;
        assertEquals(expected, actual);
    }

    public int solution(final int n) {
        return solution(0, n);
    }

    private int solution(final int steps, final int stairCases) {
        if (steps > stairCases) {
            return 0;
        }
        if (steps == stairCases) {
            return 1;
        }
        return solution(steps + 1, stairCases) + solution(steps + 2, stairCases);
    }
}
