package com.custodio.study.neetcode.linkedlist;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/reorder-list/">Neet Code</a>
 */
public class ReorderList
{
    @Test
    public void example1()
    {
        //given
        final var head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        //when
        reorderList(head);
        final var actual = head.toString();
        //then
        final var expected = "1423";
        assertEquals(expected, actual);
    }

    public void reorderList(final ListNode head)
    {
        //we will use the fast slow technic to identify the middle of the list.
        var middle = findMiddle(head);

        //Now we can split the list into two parts.
        final var firstPart = copy(head, middle);

        //Now that we found the middle of the list, we will reverse the middle part of the list.
        final var secondPart = copy(middle);
        final var reversedSecondPart = reverse(secondPart);

        //Now we need to merge the lists element by element.
        final var mergedParts = merge(firstPart, reversedSecondPart);

        //Overrides the raw list with the values from the merged parts.
        override(mergedParts, head);
    }

    private static void override(final ListNode source, final ListNode target) {
        for (ListNode targetNode = target, sourceNode = source; Objects.nonNull(sourceNode); targetNode = targetNode.next, sourceNode = sourceNode.next)
        {
            targetNode.val = sourceNode.val;
        }
    }

    private static ListNode merge(final ListNode firstPart, final ListNode reversedSecondPart)
    {
        final var list = new ListNode();
        var current = list;
        var node1 = firstPart;
        var node2 = reversedSecondPart;
        while (Objects.nonNull(node1) && Objects.nonNull(node2))
        {
            current.next = new ListNode(node1.val);
            current.next.next = new ListNode(node2.val);
            current = current.next.next;
            node1 = node1.next;
            node2 = node2.next;
        }

        while(Objects.nonNull(node1)) {
            current.next = new ListNode(node1.val);
            current = current.next;
            node1 = node1.next;
        }

        while(Objects.nonNull(node2)) {
            current.next = new ListNode(node2.val);
            current = current.next;
            node2 = node2.next;
        }
        return list.next;
    }

    private static ListNode findMiddle(final ListNode head)
    {
        var slow = head;
        for (var fast = slow.next; Objects.nonNull(fast.next); fast = fast.next)
        {
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode copy(final ListNode head, final ListNode end)
    {
        var list = new ListNode();
        var current = list;
        for (ListNode node = head; node.val != end.val; node = node.next)
        {
            current.next = new ListNode(node.val);
            current = current.next;
        }
        return list.next;
    }

    private static ListNode copy(final ListNode head)
    {
        var list = new ListNode();
        var current = list;
        var node = head;
        while (Objects.nonNull(node))
        {
            current.next = new ListNode(node.val);
            current = current.next;
            node = node.next;
        }
        return list.next;
    }

    private static ListNode reverse(final ListNode head)
    {
        var currentNode = head;
        var previousNode = (ListNode) null;
        while (Objects.nonNull(currentNode))
        {
            var next = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = next;
        }
        return previousNode;
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
