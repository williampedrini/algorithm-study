package com.custodio.study.neetcode.linkedlist;

import org.junit.Test;

import java.util.Objects;

/**
 * @see <a href="https://leetcode.com/problems/merge-two-sorted-lists/">Neet Code</a>
 */
public class MergeTwoSortedLists
{
    @Test
    public void example1()
    {
        //given
        final var list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        final var list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        //when
        final var actual = mergeTwoLists(list1, list2);
        //then
        System.out.println(actual);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        var node1 = list1;
        var node2 = list2;
        var head = new ListNode();
        var node = head;
        while (Objects.nonNull(node1) && Objects.nonNull(node2))
        {
            if(node1.val < node2.val) {
                node.next = new ListNode(node1.val);
                node1 = node1.next;
                node = node.next;
                continue;
            }
            node.next = new ListNode(node2.val);
            node = node.next;
            node2 = node2.next;
        }
        if(Objects.nonNull(node1)) {
            node.next = node1;
        }
        if(Objects.nonNull(node2)) {
            node.next = node2;
        }
        return head.next;
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
        public String toString()
        {
            final var toStringBuilder = new StringBuilder();
            toString(this, toStringBuilder);
            return toStringBuilder.toString();
        }

        public void toString(final ListNode node, final StringBuilder toStringBuilder)
        {
            if (node == null)
            {
                return;
            }
            toStringBuilder.append(node.val);
            toString(node.next, toStringBuilder);
        }
    }
}
