package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;

import static java.util.Objects.nonNull;
import static org.junit.Assert.assertTrue;

/**
 * @see <a href="https://leetcode.com/problems/palindrome-linked-list/">Leet Code</a>
 */
public class PalindromeLinkedList {

    @Test
    public void example1() {
        //given
        final var head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        //when
        final var actual = solution(head);
        //then
        assertTrue(actual);
    }

    public boolean solution(final ListNode root) {
        final var values = new ArrayList<Integer>();
        for (var node = root; nonNull(node); node = node.next) {
            values.add(node.val);
        }
        for(int index = 0, index2 = values.size() - 1; index < index2; index++, index2--) {
            final var head = values.get(index);
            final var tail = values.get(index2);
            if(!Objects.equals(head, tail)) {
                return false;
            }
        }
        return true;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(final int val) {
            this.val = val;
        }

        ListNode(final int val, final ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
