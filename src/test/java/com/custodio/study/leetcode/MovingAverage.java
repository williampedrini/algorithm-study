package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/moving-average-from-data-stream/">Leet Code</a>
 */
public class MovingAverage {

    @Test
    public void example1() {
        //given
        final var solution = new Solution(4);
        //when
        final var actual1 = solution.next(100);
        final var actual2 = solution.next(-10);
        final var actual3 = solution.next(-300);
        final var actual4 = solution.next(50);
        final var actual5 = solution.next(0);
        //then
        assertEquals(100.0, actual1, 0);
        assertEquals(45.0, actual2, 0);
        assertEquals(-70.0, actual3, 0);
        assertEquals(-40.0, actual4, 0);
        assertEquals(-65.0, actual5, 0);
    }

    public static class Solution {
        private final int size;
        private final Deque<Integer> values;

        public Solution(final int size) {
            this.size = size;
            this.values = new ArrayDeque<>(size);
        }

        public double next(final int val) {
            if (values.size() == size) {
                values.removeLast();
            }
            values.addFirst(val);
            return values
                    .stream()
                    .mapToDouble(value -> value)
                    .average()
                    .orElse(0.0);
        }
    }
}
