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
        var maxArea = 0;
        var leftIndex = 0;
        var rightIndex = heights.length - 1;
        while (leftIndex < rightIndex) {
            final var leftHeight = heights[leftIndex];
            final var rightHeight = heights[rightIndex];
            final var length = rightIndex - leftIndex;
            final var height = Math.min(leftHeight, rightHeight);
            final var area = length * height;
            maxArea = Math.max(maxArea, area);
            if (leftHeight >= rightHeight) {
                rightIndex--;
            }
            if (leftHeight < rightHeight) {
                leftIndex++;
            }
        }
        return maxArea;
    }
}
