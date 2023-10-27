package com.custodio.study.neetcode.binarysearch;

import org.junit.Assert;
import org.junit.Test;

/**
 * @see <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">Neet Code</a>
 */
public class FindMinimumInRotatedSortedArray {

    @Test
    public void example1() {
        //given
        final var input = new int[]{4, 5, 6, 7, 0, 1, 2};
        //when
        final var actual = findMin(input);
        //then
        final var expected = 0;
        Assert.assertEquals(expected, actual);
    }

    public int findMin(final int[] numbers) {
        var leftIndex = 0;
        var rightIndex = numbers.length - 1;
        while (leftIndex < rightIndex) {
            final var left = numbers[leftIndex];
            final var right = numbers[rightIndex];
            final var middleIndex = (rightIndex + leftIndex) / 2;
            final var middle = numbers[middleIndex];
            if (left > right && middle > left) {
                leftIndex = middleIndex + 1;
                continue;
            }
            if (left < right && middle > left) {
                rightIndex = middleIndex - 1;
                continue;
            }
            if (left > right && middle < left) {
                rightIndex = middleIndex;
                leftIndex++;
            }
        }
        return numbers[leftIndex];
    }
}
