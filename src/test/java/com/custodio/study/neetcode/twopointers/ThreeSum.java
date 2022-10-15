package com.custodio.study.neetcode.twopointers;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/3sum/">Neet Code</a>
 */
public class ThreeSum {

    @Test
    public void example1() {
        //given
        final var input = new int[]{-1, 0, 1, 2, -1, -4};
        //when
        final var actual = solution(input);
        //then
        final var expected = asList(asList(-1, -1, 2), asList(-1, 0, 1));
        assertEquals(expected, actual);
    }

    public List<List<Integer>> solution(final int[] numbersArray) {
        return null;
    }
}
