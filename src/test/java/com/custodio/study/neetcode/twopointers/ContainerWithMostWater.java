package com.custodio.study.neetcode.twopointers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/container-with-most-water/">Neet Code</a>
 */
public class ContainerWithMostWater {

    @Test
    public void example1() {
        //given
        final var heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        //when
        final var actual = maxArea(heights);
        //then
        final var expected = 49;
        assertEquals(expected, actual);
    }

    public int maxArea(final int[] heights) {
        return -1;
    }
}
