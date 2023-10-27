package com.custodio.study.neetcode.microsoft;

import org.junit.Test;

import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array">Neet Code</a>
 */
public class KthLargestElementInAnArray
{
    @Test
    public void example1()
    {
        //given
        final var numbers = new int[]{3, 2, 1, 5, 6, 4};
        final var target = 2;
        //when
        final var actual = findKthLargest(numbers, target);
        //then
        final var expected = 5;
        assertEquals(expected, actual);
    }

    public int findKthLargest(final int[] numbers, final int target)
    {
        final Queue<Integer> heap = new PriorityQueue<>();

        for (final var number : numbers)
        {
            heap.add(number);
            if (heap.size() > target)
            {
                heap.poll();
            }
        }
        return Optional.ofNullable(heap.peek()).orElse(-1);
    }
}
