package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.HashMap;

import static java.lang.Integer.MAX_VALUE;
import static org.junit.Assert.assertEquals;

public class SearchInsertPosition {

    @Test
    public void example1() {
        //when
        final var actual = searchInsert(new int[]{1, 3, 5, 6}, 5);
        //then
        final var expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        //when
        final var actual = searchInsert(new int[]{1, 3, 5, 6}, 2);
        //then
        final var expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        //when
        final var actual = searchInsert(new int[]{1, 3, 5, 6}, 7);
        //then
        final var expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void example4() {
        //when
        final var actual = searchInsert(new int[]{1, 3, 5, 6}, 7);
        //then
        final var expected = 4;
        assertEquals(expected, actual);
    }

    /**
     * begin = 0
     * end = -1
     * lastMiddleIndex = 0
     */
    @Test
    public void example5() {
        //when
        final var actual = searchInsert(new int[]{1, 3, 5, 6}, 0);
        //then
        final var expected = 0;
        assertEquals(expected, actual);
    }

    /**
     * begin = 1
     * end = 0
     * lastMiddleIndex = 1
     */
    @Test
    public void example6() {
        //when
        final var actual = searchInsert(new int[]{1, 3}, 2);
        //then
        final var expected = 1;
        assertEquals(expected, actual);
    }

    private int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length - 1, -1);
    }

    private int searchInsert(int[] numbers, int target, int begin, int end, int lastMiddleIndex) {
        if (begin > end) {
            final var result = new HashMap<Integer, Integer>();

            if(end > -1) {
                if (lastMiddleIndex - 1 > -1) {
                    result.put(lastMiddleIndex - 1, target - numbers[lastMiddleIndex - 1]);
                }
                if (lastMiddleIndex + 1 < numbers.length) {
                    result.put(lastMiddleIndex + 1, target - numbers[lastMiddleIndex + 1]);
                }
                result.put(lastMiddleIndex, target - numbers[lastMiddleIndex]);
            } else {
                if (lastMiddleIndex - 1 > -1) {
                    result.put(lastMiddleIndex - 1, numbers[lastMiddleIndex - 1] - target);
                }

                if (lastMiddleIndex + 1 < numbers.length) {
                    result.put(lastMiddleIndex + 1, numbers[lastMiddleIndex + 1] - target);
                }

                result.put(lastMiddleIndex, numbers[lastMiddleIndex] - target);
            }

            var minimumIndex = -1;
            var minimumValue = MAX_VALUE;

            for (var entry : result.entrySet()) {
                var index = entry.getKey();
                var difference = entry.getValue();
                if (difference < minimumValue) {
                    minimumIndex = index;
                    minimumValue = difference;
                }
            }

            return minimumIndex + 1;
        }

        final var middleIndex = (begin + end) / 2;
        final var middle = numbers[middleIndex];
        if (middle == target) {
            return middleIndex;
        }

        if (middle > target) {
            return searchInsert(numbers, target, begin, middleIndex - 1, middleIndex);
        }
        return searchInsert(numbers, target, middleIndex + 1, end, middleIndex);
    }
}