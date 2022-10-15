package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertTrue;

/**
 * @see <a href="https://leetcode.com/problems/linked-list-cycle/">Leet Code</a>
 */
public class LinkedListCycle {

    @Test
    public void example1() {
        //given
        final var tail = new ListNode(-4);
        final var third = new ListNode(0, tail);
        final var second = new ListNode(2, third);
        final var head = new ListNode(3, second);
        tail.next = second;
        //when
        final var actual = solution(head);
        //then
        assertTrue(actual);
    }

    public boolean solution(final ListNode head) {
        final var visitedNodes = new HashSet<ListNode>();
        for (var node = head; node != null; node = node.next) {
            if (visitedNodes.contains(node)) {
                return true;
            }
            visitedNodes.add(node);
        }
        return false;
    }

    private static class ListNode {
        private final int val;
        private ListNode next;

        ListNode(final int value) {
            this(value, null);
        }

        public ListNode(final int val, final ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}