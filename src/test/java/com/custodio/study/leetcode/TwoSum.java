package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.HashMap;

import static java.util.Arrays.sort;
import static org.junit.Assert.assertArrayEquals;

/**
 * @see <a href="https://leetcode.com/problems/two-sum/">Leet Code</a>
 */
public class TwoSum {

    /**
     * WHEN
     * nums = [2,7,11,15] AND target = 9
     * THEN
     * returns [0,1]
     */
    @Test
    public void example1() {
        //when
        final var actual = solution(new int[]{2, 7, 11, 15}, 9);
        //then
        final var expected = new int[]{0, 1};
        assertArrayEquals(expected, actual);
    }

    /**
     * WHEN
     * nums = [3,2,4], target = 6
     * THEN
     * returns [1,2]
     */
    @Test
    public void example2() {
        //when
        final var actual = solution(new int[]{3, 2, 4}, 6);
        //then
        final var expected = new int[]{1, 2};
        assertArrayEquals(expected, actual);
    }

    /**
     * WHEN
     * nums = [3,3], target = 6
     * THEN
     * returns [0,1]
     */
    @Test
    public void example3() {
        //when
        final var actual = solution(new int[]{3, 3}, 6);
        //then
        final var expected = new int[]{0, 1};
        assertArrayEquals(expected, actual);
    }

    public int[] solution(int[] numbers, int target) {
        final var indexByNumber = new HashMap<Integer, Integer>();
        for (var index = 0; index < numbers.length; index++) {
            var number = numbers[index];
            var difference = target - number;
            var differenceIndex = indexByNumber.get(difference);
            if (differenceIndex == null) {
                indexByNumber.put(number, index);
                continue;
            }
            final var result = new int[]{index, differenceIndex};
            sort(result);
            return result;
        }
        return new int[]{};
    }
}
