package com.custodio.study.neetcode.slidingwindow;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @see <a href="https://leetcode.com/problems/sliding-window-maximum/">Neet Code</a>
 */
public class SlidingWindowMaximum {

    @Test
    public void example1() {
        //given
        final var inputNumbers = new int[]{1, 3, 1, 2, 0, 5};
        final var inputSize = 3;
        //when
        final var actual = maxSlidingWindow(inputNumbers, inputSize);
        //then
        final var expected = new int[]{3, 3, 2, 5};
        assertArrayEquals(expected, actual);
    }

    public int[] maxSlidingWindow(final int[] numbers, final int size) {
        return null;
    }
}

















