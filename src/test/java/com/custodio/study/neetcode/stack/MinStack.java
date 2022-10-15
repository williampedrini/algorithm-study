package com.custodio.study.neetcode.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/min-stack/">Neet Code</a>
 */
public class MinStack {

    @Test
    public void example1() {
        final var minStack = new Solution();
        {
            //given
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);
            //when
            final var actual = minStack.getMin();
            //then
            final var expected = -3;
            assertEquals(expected, actual);
        }
        {
            //given
            minStack.pop();
            //when
            final var actualTop = minStack.top();
            final var actualMin = minStack.getMin();
            //then
            final var expectedTop = 0;
            assertEquals(expectedTop, actualTop);

            final var expectedMin = -2;
            assertEquals(expectedMin, actualMin);
        }
    }

    static class Solution {
        public Solution() {
        }

        public void push(final int value) {
        }

        public void pop() {
        }

        public int top() {
            return -1;
        }

        public int getMin() {
            return -1;
        }
    }
}
