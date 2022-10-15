package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;

/**
 * @see <a href="https://leetcode.com/problems/merge-sorted-array/">Leet Code</a>
 */
public class MergeSortedArray {

    /**
     * WHEN
     * nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * THEN
     * returns [1,2,2,3,5,6]
     */
    @Test
    public void example1() {
        //given
        final var numbers1 = new int[]{1, 2, 3, 0, 0, 0};
        final var size1 = 3;

        final var numbers2 = new int[]{2, 5, 6};
        final var size2 = 3;

        //when
        solution(numbers1, size1, numbers2, size2);

        //then
        final var expected = new int[]{1, 2, 2, 3, 5, 6};
        assertArrayEquals(expected, numbers1);
    }

    /**
     * WHEN
     * nums1 = [1], m = 1, nums2 = [], n = 0
     * THEN
     * returns [1]
     */
    @Test
    public void example2() {
        //given
        final var numbers1 = new int[]{1};
        final var size1 = 1;

        final var numbers2 = new int[]{};
        final var size2 = 0;

        //when
        solution(numbers1, size1, numbers2, size2);

        //then
        final var expected = new int[]{1};
        assertArrayEquals(expected, numbers1);
    }

    private void solution(int[] nums1, int m, int[] nums2, int n) {
        var result = new ArrayList<Integer>();
        var index1 = 0;
        var index2 = 0;
        while (index1 < m || index2 < n) {
            if (index1 < m && index2 < n) {
                final var number1 = nums1[index1];
                final var number2 = nums2[index2];
                if (number1 < number2) {
                    result.add(number1);
                    index1++;
                } else {
                    result.add(number2);
                    index2++;
                }
                continue;
            }
            if (index1 < m) {
                final var number = nums1[index1];
                result.add(number);
                index1++;
            }
            if (index2 < n) {
                final var number = nums2[index2];
                result.add(number);
                index2++;
            }

        }
        for (var index = 0; index < m + n; index++) {
            nums1[index] = result.get(index);
        }
    }
}
