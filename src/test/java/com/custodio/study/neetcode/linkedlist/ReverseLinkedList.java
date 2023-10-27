package com.custodio.study.neetcode.linkedlist;

import org.junit.Test;

import java.util.Objects;

/**
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/">Neet Code</a>
 */
public class ReverseLinkedList
{
    @Test
    public void example1()
    {
        //given
        final var head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        //when
        final var actual = reverseList(head);
        //then
        System.out.println(actual);
    }

    public ListNode reverseList(ListNode head)
    {
        for (ListNode node = head, previous = null; Objects.nonNull(node); )
        {
            final var next = node.next;
            node.next = previous;
            previous = node;
            head = previous;
            node = next;
        }
        return head;
    }

    public static class ListNode
    {
        int val;
        ListNode next;

        ListNode()
        {
        }

        ListNode(int val)
        {
            this.val = val;
        }

        ListNode(int val, ListNode next)
        {
            this.val = val; this.next = next;
        }

        @Override
        public String toString() {
            final var toStringBuilder = new StringBuilder();
            toString(this, toStringBuilder);
            return toStringBuilder.toString();
        }

        public void toString(final ListNode node, final StringBuilder toStringBuilder) {
            if(node == null) {
                return;
            }
            toStringBuilder.append(node.val);
            toString(node.next, toStringBuilder);
        }
    }
}
