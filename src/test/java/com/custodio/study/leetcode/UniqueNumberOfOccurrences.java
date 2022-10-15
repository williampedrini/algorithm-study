package com.custodio.study.leetcode;

import org.junit.Test;

import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @see <a href="https://leetcode.com/problems/merge-sorted-array/">Leet Code</a>
 */
public class UniqueNumberOfOccurrences {

    @Test
    public void example1() {
        //given
        final var input = new int[]{1, 2, 2, 1, 1, 3};
        //when
        final var actual = solution(input);
        //then
        assertTrue(actual);
    }

    @Test
    public void example2() {
        //given
        final var input = new int[]{1, 2};
        //when
        final var actual = solution(input);
        //then
        assertFalse(actual);
    }

    public boolean solution(final int[] inputs) {
        return stream(inputs)
                .boxed()
                .collect(groupingBy(identity(), counting()))
                .values()
                .stream()
                .collect(groupingBy(identity(), counting()))
                .values()
                .stream()
                .noneMatch(value -> value > 1);
    }
}
