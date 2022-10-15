package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/subarray-sum-equals-k/">Leet Code</a>
 */
public class SubarraySumEqualsK {

    @Test
    public void example1() {
        //given
        final var input = new int[]{1, 1, 1};
        //when
        final var actual = subarraySum(input, 2);
        //then
        final var expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        //given
        final var input = new int[]{1, 2, 3};
        //when
        final var actual = subarraySum(input, 3);
        //then
        final var expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        //given
        final var input = new int[]{1, -1, 0};
        //when
        final var actual = subarraySum(input, 0);
        //then
        final var expected = 3;
        assertEquals(expected, actual);
    }

    public int subarraySum(final int[] nums, final int k) {
        var sum = 0;
        var counter = 0;
        var differences = new HashMap<Integer, Integer>();
        differences.put(0, 1);
        for (int num : nums) {
            sum += num;
            final var difference = sum - k;
            if (differences.containsKey(difference)) {
                counter += differences.get(sum - k);
            }
            final var amountPerSum = differences.getOrDefault(sum, 0);
            differences.put(sum, amountPerSum + 1);
        }
        return counter;
    }
}
