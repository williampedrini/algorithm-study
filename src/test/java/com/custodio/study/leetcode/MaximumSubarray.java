package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.Collection;
import java.util.TreeSet;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.max;
import static java.util.Comparator.reverseOrder;
import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/maximum-subarray/">Leet Code</a>
 */
public class MaximumSubarray {

    /**
     * WHEN
     * nums = [-2,1,-3,4,-1,2,1,-5,4]
     * THEN
     * returns 6
     */
    @Test
    public void example1() {
        //given
        final var nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //when
        final var actual = solution(nums);
        //then
        final var expected = 6;
        assertEquals(expected, actual);
    }

    public int solution(int[] nums) {
        final var sums = new TreeSet<Long>(reverseOrder());
        solution(nums, 0, sums);
        return sums.first().intValue();
    }

    private void solution(final int[] nums, final int begin, final Collection<Long> sums) {
        if (begin > nums.length) {
            return;
        }
        var total = 0;
        var max = MIN_VALUE;
        for (var index = begin; index < nums.length; index++) {
            total += nums[index];
            max = max(total, max);
        }
        sums.add((long) max);
        solution(nums, begin + 1, sums);
    }
}
