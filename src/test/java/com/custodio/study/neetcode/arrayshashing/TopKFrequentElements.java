package com.custodio.study.neetcode.arrayshashing;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.PriorityQueue;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * @see <a href="https://leetcode.com/problems/top-k-frequent-elements/">Neet Code</a>
 */
public class TopKFrequentElements
{
    @Test
    public void example1()
    {
        //given
        final var numbers = new int[]{4, 1, -1, 2, -1, 2, 3};
        final var limit = 2;
        //when
        final var actual = solution(numbers, limit);
        //then
        final var expected = new int[]{-1, 2};
        Assert.assertArrayEquals(expected, actual);
    }

    public int[] solution(final int[] numbers, final int limit)
    {
        final Map<Integer, Long> map = Arrays.stream(numbers)
                                             .boxed()
                                             .collect(groupingBy(identity(), counting()));

        final var queue = new PriorityQueue<Entry<Integer, Long>>((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        queue.addAll(map.entrySet());

        final var result = new int[limit];
        for (var index = 0; index < limit; index++)
        {
            final var entry = queue.poll();
            if (Objects.nonNull(entry))
            {
                result[index] = Math.toIntExact(entry.getKey());
            }
        }
        return result;
    }
}
