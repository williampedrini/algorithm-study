package com.custodio.study.neetcode.stack;

import org.junit.Test;

import java.util.Stack;

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
        private final Stack<Integer> values;
        private final Stack<Integer> minValues;

        public Solution() {
            values = new Stack<>();
            minValues = new Stack<>();
        }

        public void push(final int value) {
            if (values.isEmpty()) {
                values.push(value);
                minValues.push(value);
                return;
            }
            final var lastMinValue = minValues.peek();
            final var newMinValue = Math.min(lastMinValue, value);
            minValues.push(newMinValue);
            values.push(value);
        }

        public void pop() {
            values.pop();
            minValues.pop();
        }

        public int top() {
            return values.peek();
        }

        public int getMin() {
            return minValues.peek();
        }
    }
}
