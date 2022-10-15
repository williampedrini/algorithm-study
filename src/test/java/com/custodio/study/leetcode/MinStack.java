package com.custodio.study.leetcode;

import static java.lang.Math.min;
import static java.util.Optional.ofNullable;

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">Leet Code</a>
 */
public class MinStack {

    private static class InternalMinStack {
        private Node top;
        private int minimumValue;

        public void push(final int val) {
            top = new Node(val, top);
            minimumValue = getMin(top);
        }

        public void pop() {
            ofNullable(top).ifPresent(top -> this.top = top.next);
            minimumValue = getMin(top);
        }

        public int top() {
            return ofNullable(top)
                    .map(node -> node.value)
                    .orElse(0);
        }

        public int getMin() {
            return minimumValue;
        }

        public int getMin(final Node top) {
            if (top == null) {
                return 0;
            }
            if (top.next == null) {
                return top.value;
            }
            return min(top.value, getMin(top.next));
        }
    }

    private static class Node {
        private final int value;
        private final Node next;

        Node(final int value) {
            this(value, null);
        }

        public Node(final int val, final Node next) {
            this.value = val;
            this.next = next;
        }
    }
}
