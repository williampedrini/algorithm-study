package com.custodio.study.neetcode.arrayshashing;

import org.junit.Test;

import static java.lang.Math.max;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/longest-consecutive-sequence/">Neet Code</a>
 */
public class LongestConsecutiveSequence {

    @Test
    public void example1() {
        //given
        final var input = new int[]{100, 4, 200, 1, 3, 2};
        //when
        final var actual = solution(input);
        //then
        final var expected = 4;
        assertEquals(expected, actual);
    }

    public int solution(final int[] input) {
        final var numbers = stream(input).boxed().collect(toSet());

        var longestConsecutiveSequence = 0;

        for (var number : input) {
            var predecessor = number - 1;
            if (numbers.contains(predecessor)) {
                continue;
            }
            var counter = 0;
            while (numbers.contains(number + counter)) {
                counter++;
            }
            longestConsecutiveSequence = max(longestConsecutiveSequence, counter);
        }
        return longestConsecutiveSequence;
    }
}
