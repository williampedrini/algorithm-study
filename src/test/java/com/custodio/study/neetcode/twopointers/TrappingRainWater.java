package com.custodio.study.neetcode.twopointers;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;

import static java.lang.Math.max;
import static java.lang.Math.min;
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
        //1: Get the highest left height for each position.
        var highestLeftHeight = 0;
        var highestLeftHeights = new ArrayList<Integer>();
        for (final int height : heights) {
            highestLeftHeights.add(highestLeftHeight);
            highestLeftHeight = max(highestLeftHeight, height);
        }
        //2: Get the highest right height for each position.
        var highestRightHeight = 0;
        final var highestRightHeights = new ArrayDeque<Integer>();
        for (var index = heights.length - 1; index > -1; index--) {
            final var height = heights[index];
            highestRightHeights.push(highestRightHeight);
            highestRightHeight = max(highestRightHeight, height);
        }
        //0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        //3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1, 0
        //3: Get the minimum value for each position.
        final var lowestHeights = new ArrayList<Integer>();
        for (var index = 0; index < heights.length; index++) {
            final var leftHeight = highestLeftHeights.get(index);
            final var rightHeight = highestRightHeights.pop();
            final var lowestHeight = min(leftHeight, rightHeight);
            lowestHeights.add(lowestHeight);
        }
        //4: Get the difference between the lowest height and the current height.
        final var trappedRainWater = new ArrayList<Integer>();
        for (var index = 0; index < heights.length; index++) {
            final var lowestHeight = lowestHeights.get(index);
            final var height = heights[index];
            final var amountOfWater = lowestHeight - height;
            final var normalizedAmountOfWater = Math.max(0, amountOfWater);
            trappedRainWater.add(normalizedAmountOfWater);
        }
        return trappedRainWater
                .stream()
                .mapToInt(waterAmount -> waterAmount)
                .sum();
    }
}
