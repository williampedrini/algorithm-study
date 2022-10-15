package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;
import static java.util.List.of;
import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/fizz-buzz/">Leet Code</a>
 */
public class FizzBuzz {

    @Test
    public void example1() {
        //given
        final var number = 3;
        //when
        final var actual = solution(number);
        //then
        final var expected = of("1", "2", "Fizz");
        assertEquals(expected, actual);
    }

    public List<String> solution(final int number) {
        final var result = new ArrayList<String>();
        for (var index = 1; index < number + 1; index++) {
            final var isDivisibleByFive = index % 5 == 0;
            final var isDivisibleByThree = index % 3 == 0;
            if (isDivisibleByFive && isDivisibleByThree) {
                result.add("FizzBuzz");
            } else if (isDivisibleByFive) {
                result.add("Buzz");
            } else if (isDivisibleByThree) {
                result.add("Fizz");
            } else {
                result.add(valueOf(index));
            }
        }
        return result;
    }
}
