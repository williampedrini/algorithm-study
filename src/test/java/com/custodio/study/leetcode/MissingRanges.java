package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.lang.Math.abs;
import static java.lang.String.valueOf;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/missing-ranges/">Leet Code</a>
 */
public class MissingRanges {

    @Test
    public void example1() {
        //given
        final var numbers = new int[]{0, 1, 3, 50, 75};
        final var lower = 0;
        final var upper = 99;
        //when
        final var actual = solution(numbers, lower, upper);
        //then
        final var expected = asList("2", "4->49", "51->74", "76->99");
        assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        //given
        final var numbers = new int[]{-1};
        final var lower = -1;
        final var upper = -1;
        //when
        final var actual = solution(numbers, lower, upper);
        //then
        final var expected = List.of();
        assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        //given
        final var numbers = new int[]{};
        final var lower = 1;
        final var upper = 1;
        //when
        final var actual = solution(numbers, lower, upper);
        //then
        final var expected = List.of("1");
        assertEquals(expected, actual);
    }

    @Test
    public void example4() {
        //given
        final var numbers = new int[]{-1};
        final var lower = -1;
        final var upper = 0;
        //when
        final var actual = solution(numbers, lower, upper);
        //then
        final var expected = List.of("0");
        assertEquals(expected, actual);
    }

    public Collection<String> solution(final int[] numbers, final int lower, final int upper) {

        var result = new ArrayList<String>();

        if (numbers.length == 0) {
            if (abs(upper - lower) > 0) {
                result.add(lower + "->" + upper);
                return result;
            }
            result.add(valueOf(lower));
            return result;
        }

        var index = 0;
        var expected = lower;

        while (index < numbers.length) {
            final var current = numbers[index];
            if (expected == current) {
                index++;
                expected = current + 1;
                continue;
            }
            if (abs(expected - current) > 1) {
                final var end = current - 1;
                final var range = expected + "->" + end;
                result.add(range);
            } else {
                result.add(valueOf(expected));
            }
            expected = current + 1;
            index++;
        }

        final var current = numbers[index - 1];
        final var difference = abs(upper - current);
        if (difference > 1) {
            final var range = (current + 1) + "->" + upper;
            result.add(range);
        } else if (upper != current) {
            result.add(String.valueOf(upper));
        }
        return result;
    }
}
