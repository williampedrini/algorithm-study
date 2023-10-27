package com.custodio.study.neetcode.binarysearch;

import org.junit.Assert;
import org.junit.Test;

/**
 * @see <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">Neet Code</a>
 */
public class SearchInRotatedSortedArray {

    @Test
    public void example1() {
        //given
        final var numbers = new int[]{4, 5, 6, 7, 0, 1, 2};
        final var target = 0;
        //when
        final var actual = search(numbers, target);
        //then
        final var expected = 4;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        //given
        final var numbers = new int[]{5, 1, 3};
        final var target = 0;
        //when
        final var actual = search(numbers, target);
        //then
        final var expected = -1;
        Assert.assertEquals(expected, actual);
    }

    public int search(final int[] numbers, final int target) {
        var leftIndex = 0;
        var rightIndex = numbers.length - 1;
        while (leftIndex <= rightIndex) {
            final var middleIndex = (rightIndex + leftIndex) / 2;
            final var middle = numbers[middleIndex];
            final var left = numbers[leftIndex];
            if (target == middle) {
                return middleIndex;
            }
            if (middle >= left && (target > middle || target < left)) {
                leftIndex = middleIndex + 1;
                continue;
            }
            if (target > middle && target < left) {
                leftIndex = middleIndex + 1;
                continue;
            }
            rightIndex = middleIndex - 1;
        }
        return -1;
    }
}
