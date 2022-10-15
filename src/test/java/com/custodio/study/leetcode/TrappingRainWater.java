package com.custodio.study.leetcode;

import org.junit.Test;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/trapping-rain-water/">Leet Code</a>
 */
public class TrappingRainWater {

    @Test
    public void example1() {
        //given
        final var heights = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        //when
        final var actual = trap(heights);
        //then
        final var expected = 6;
        assertEquals(expected, actual);
    }

    public int trap(final int[] heights) {
        final var lefts = new int[heights.length];
        for (var index = 0; index < heights.length; index++) {
            for (var left = 0; left < index; left++) {
                lefts[index] = max(lefts[index], heights[left]);
            }
        }

        final var rights = new int[heights.length];
        for (var index = 0; index < heights.length; index++) {
            for (var right = heights.length - 1; right > index; right--) {
                rights[index] = max(rights[index], heights[right]);
            }
        }

        final var minimums = new int[heights.length];
        for (var index = 0; index < heights.length; index++) {
            final var left = lefts[index];
            final var right = rights[index];
            minimums[index] = min(left, right);
        }

        var counter = 0;
        for (var index = 0; index < heights.length; index++) {
            final var height = heights[index];
            final var minimum = minimums[index];
            final var difference = minimum - height;
            if (difference > 0) {
                counter += difference;
            }
        }
        return counter;
    }
}
