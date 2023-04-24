package com.custodio.study.neetcode.twopointers;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @see <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">Neet Code</a>
 */
public class TwoSum2InputArrayIsSorted {

    @Test
    public void example1() {
        //given
        final var numbers = new int[]{2, 7, 11, 15};
        final var target = 9;
        //when
        final var actual = solution(numbers, target);
        //then
        final var expected = new int[]{1, 2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void example2() {
        //given
        final var numbers = new int[]{2, 3, 4};
        final var target = 6;
        //when
        final var actual = solution(numbers, target);
        //then
        final var expected = new int[]{1, 3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void example3() {
        //given
        final var numbers = new int[]{-1, 0};
        final var target = -1;
        //when
        final var actual = solution(numbers, target);
        //then
        final var expected = new int[]{1, 2};
        assertArrayEquals(expected, actual);
    }

    public int[] solution(final int[] numbers, final int target) {
        var leftIndex = 0;
        var rightIndex = numbers.length - 1;
        while (leftIndex < rightIndex) {
            final var left = numbers[leftIndex];
            final var right = numbers[rightIndex];
            if (left + right == target) {
                return new int[]{leftIndex + 1, rightIndex + 1};
            }
            if (left + right < target) {
                leftIndex++;
            }
            if (left + right > target) {
                rightIndex--;
            }
        }
        return null;
    }
}
