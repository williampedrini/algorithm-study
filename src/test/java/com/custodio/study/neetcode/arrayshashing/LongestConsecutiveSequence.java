package com.custodio.study.neetcode.arrayshashing;

import org.junit.Assert;
import org.junit.Test;

/**
 * @see <a href="https://leetcode.com/problems/longest-consecutive-sequence/">Neet Code</a>
 */
public class LongestConsecutiveSequence {

    @Test
    public void example1() {
        //given
        final var input = new int[]{100, 4, 200, 1, 3, 2};
        //when
        final var actual = solution(input);
        //then
        final var expected = 4;
        Assert.assertEquals(expected, actual);
    }

    public int solution(final int[] input) {
        return -1;
    }
}
