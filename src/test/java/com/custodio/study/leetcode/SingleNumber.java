package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/valid-palindrome/">Leet Code</a>
 */
public class SingleNumber {

    @Test
    public void example1() {
        //given
        final var numbers = new int[]{4, 1, 2, 1, 2};
        //when
        final var actual = solution(numbers);
        //then
        final var expected = 1;
        assertEquals(expected, actual);
    }

    public int solution(final int[] numbers) {
        final var timesPerNumber = new HashMap<Integer, Integer>();
        for (final var number : numbers) {
            final var times = timesPerNumber.getOrDefault(number, 0);
            timesPerNumber.put(number, times + 1);
        }
        return timesPerNumber
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findAny()
                .map(Map.Entry::getKey)
                .orElse(-1);
    }
}
