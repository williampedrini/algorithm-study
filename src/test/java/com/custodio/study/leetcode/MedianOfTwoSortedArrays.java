package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/">Leet Code</a>
 */
public class MedianOfTwoSortedArrays {

    @Test
    public void example1() {
        //given
        final var number1 = new int[]{1, 3};
        final var number2 = new int[]{2};
        //when
        final var actual = findMedianSortedArrays(number1, number2);
        //then
        final var expected = 0.0;
        assertEquals(expected, actual, 0.0);
    }

    public double findMedianSortedArrays(final int[] nums1, final int[] nums2) {

        final var result = new ArrayList<>();

        for (int index1 = 0, index2 = 0; index1 < nums1.length && index2 < nums2.length; index1++, index2++) {

        }

        return -1.0;
    }
}
