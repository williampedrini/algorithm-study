package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import static org.junit.Assert.assertTrue;

/**
 * @see <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">Leet Code</a>
 */
public class IntersectionOfTwoLinkedLists {

    @Test
    public void example1() {
        //given
        final var intersection = new ListNode(8, new ListNode(4, new ListNode(5)));
        final var list1 = new ListNode(4, new ListNode(1, intersection));
        final var list2 = new ListNode(5, new ListNode(6, new ListNode(1, intersection)));
        //when
        final var actual = solution(list1, list2);
        //then
        final var expected = new ListNode(8, new ListNode(4, new ListNode(5)));
        assertTrue(ListNode.equals(expected, actual));
    }

    public ListNode solution(final ListNode source, final ListNode target) {
        final var sourceList = new HashSet<ListNode>();
        for (var node = source; node != null; node = node.next) {
            sourceList.add(node);
        }
        for (var node = target; node != null; node = node.next) {
            if (sourceList.contains(node)) {
                return node;
            }
        }
        return null;
    }

    private static class ListNode {
        private final int val;
        private final ListNode next;

        ListNode(final int value) {
            this(value, null);
        }

        public ListNode(final int val, final ListNode next) {
            this.val = val;
            this.next = next;
        }

        private static boolean equals(final ListNode source, final ListNode target) {
            if (source == null && target == null) {
                return true;
            }
            if (source == null) {
                return false;
            }
            if (target == null) {
                return false;
            }
            if (source.val != target.val) {
                return false;
            }
            return equals(source.next, target.next);
        }

        @Override
        public String toString() {
            final var valuesToPrint = new ArrayList<Integer>();
            toString(valuesToPrint, this);
            return valuesToPrint.toString();
        }

        private void toString(final Collection<Integer> values, final ListNode node) {
            if (node == null) {
                return;
            }
            values.add(node.val);
            toString(values, node.next);
        }
    }
}
