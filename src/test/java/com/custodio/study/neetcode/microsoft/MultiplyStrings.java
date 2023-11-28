package com.custodio.study.neetcode.microsoft;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

/**
 * @see <a href="https://leetcode.com/problems/multiply-strings/?envType=featured-list&envId=top-microsoft-questions?envType=featured-list&envId=top-microsoft-questions">Neet Code</a>
 */
public class MultiplyStrings
{
    @Test
    public void example1()
    {
        //given
        final var number1 = "123";
        final var number2 = "456";
        //when
        final var actual = solution(number1, number2);
        //then
        final var expected = "56088";
        Assert.assertEquals(expected, actual);
    }

    public String solution(final String number1, final String number2)
    {
        //1: Reverse the numbers to start multiplying from the last position.
        final var reversedNumber1 = new StringBuilder(number1).reverse().toString();
        final var reversedNumber2 = new StringBuilder(number2).reverse().toString();

        //2: Create a new array containing only 0.
        final int[] result = IntStream.range(0, number1.length() + number2.length())
                                      .map(index -> 0)
                                      .toArray();

        //3: Multiply each digit of the array individually.
        for (int i = 0; i < reversedNumber1.length(); i++)
        {
            for (int j = 0; j < reversedNumber2.length(); j++)
            {
                final var digit1 = reversedNumber1.charAt(i);
                final var digit2 = reversedNumber2.charAt(j);
                final var multiplication = Character.getNumericValue(digit1) * Character.getNumericValue(digit2);

                // 4: Sum the multiplication of the current digits with the current sub result of the position we are in.
                // The position we are in is calculated by i + j.
                result[i + j] += multiplication;

                //5: The next position will receive the carrier.
                result[i + j + 1] += result[i + j] / 10;

                //6: The current position will only get the first digit of the current value.
                // The way to do that is by performing the mod operation against 10.
                result[i + j] = result[i + j] % 10;
            }
        }

        // 7: Now we will reverse the result.
        final StringBuilder reversedResultBuilder = new StringBuilder();
        for (int index = result.length - 1; index > -1; index--)
        {
            final int digit = result[index];
            reversedResultBuilder.append(digit);
        }

        // 8.1: Now there is the necessity of removing the leading zeros from the result.
        // We will initially identify the first position without zero.
        for (int index = 0; index < reversedResultBuilder.length(); index++)
        {
            final char digit = reversedResultBuilder.charAt(index);
            if (digit == '0')
            {
                reversedResultBuilder.deleteCharAt(index);
                continue;
            }
            break;
        }

        // 8.2: Now we will build the result from the position where we found the first non-zero digit.
        return reversedResultBuilder.toString();
    }
}