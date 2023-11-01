package com.custodio.study.neetcode.microsoft;

import org.junit.Test;

import static java.lang.Integer.MAX_VALUE;
import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/reverse-integer">Neet Code</a>
 */
public class ReverseInteger
{

    @Test
    public void example1()
    {
        //given
        final var number = -123;
        //when
        final var actual = reverse(number);
        //then
        final var expected = -321;
        assertEquals(expected, actual);
    }

    public int reverse(int x)
    {
        // We will perform the mod 10 of the number to get the last digit of the number.
        // Once we have this digit we will add it to the final result.
        // For each iteration we will need to multiply by 10 to increase one number case.
        // E.g:
        // Given 123
        // #1 Iteration: mod10(123) = 3 and result = 3
        // #2 Iteration: mod10(12) = 2 and result = 3 * 10 + 2

        var result = 0;
        for (int carrier, number = Math.abs(x); number > 0; number = number / 10)
        {
            if (result > MAX_VALUE / 10)
            {
                return -1;
            }
            carrier = number % 10;
            result = (result * 10) + carrier;
        }
        return x > 0 ? result : result * -1;
    }
}
