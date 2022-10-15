package com.custodio.study.neetcode.twopointers;

import org.junit.Test;

import static java.lang.Math.max;
import static java.util.Arrays.stream;
import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/trapping-rain-water/">Neet Code</a>
 */
public class TrappingRainWater {

    @Test
    public void example1() {
        //given
        final var heights = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        //when
        final var actual = solution(heights);
        //then
        final var expected = 6;
        assertEquals(expected, actual);
    }

    public int solution(final int[] heights) {
        return -1;
    }
}
