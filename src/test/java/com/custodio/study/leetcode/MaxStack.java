package com.custodio.study.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.util.Comparator.reverseOrder;

/**
 * @see <a href="https://leetcode.com/problems/merge-sorted-array/">Leet Code</a>
 */
public class MaxStack {

    private static class MaxStackClazz {
        private final Queue<Integer> orderedValues = new PriorityQueue<>(reverseOrder());
        private final Deque<Integer> values = new ArrayDeque<>();

        public MaxStackClazz() {
        }

        public void push(final int value) {
            values.push(value);
            orderedValues.add(value);
        }

        public int pop() {
            final var value = values.pop();
            orderedValues.remove(value);
            return value;
        }

        public int top() {
            return values.peek();
        }

        public int peekMax() {
            return orderedValues.peek();
        }

        public int popMax() {
            final var value = orderedValues.remove();
            values.remove(value);
            return value;
        }
    }
}
