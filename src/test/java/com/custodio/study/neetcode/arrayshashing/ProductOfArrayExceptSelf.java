package com.custodio.study.neetcode.arrayshashing;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/product-of-array-except-self/">Neet Code</a>
 */
public class ProductOfArrayExceptSelf
{

    @Test
    public void example1()
    {
        //given
        final var input = new int[]{2, 3, 5, 0};
        //when
        final var actual = solution(input);
        //then
        final var expected = new int[]{0, 0, 0, 30};
        Assert.assertArrayEquals(expected, actual);
    }

    public int[] solution(final int[] numbers)
    {
        //We need to calculate the multiplication of all numbers on the left of the numbers[i].
        final var lefts = new ArrayList<Integer>();

        for (var index = 0; index < numbers.length; index++)
        {
            //The first number will never have a left previous number. The default is 1.
            if (index == 0)
            {
                lefts.add(1);
                continue;
            }
            final var previousLeft = lefts.get(index - 1);
            final var previousNumber = numbers[index - 1];
            final var result = previousNumber * previousLeft;
            lefts.add(result);
        }

        //We need to calculate the multiplication of all numbers on the right of the numbers[i];
        final var rights = new Stack<Integer>();
        for (var index = numbers.length - 1; index > -1; index--)
        {
            //The first number will never have a left previous number. The default is 1.
            if (index == numbers.length - 1)
            {
                rights.push(1);
                continue;
            }
            final var previousRight = rights.peek();
            final var previousNumber = numbers[index + 1];
            final var result = previousNumber * previousRight;
            rights.push(result);
        }

        //We need to calculate the multiplication between lefts[i] and rights[i].
        final var results = new ArrayList<Integer>();
        for (var index = 0; index < numbers.length; index++)
        {
            final var left = lefts.get(index);
            final var right = rights.pop();
            final var result = left * right;
            results.add(result);
        }
        return results.stream().mapToInt(result -> result).toArray();
    }
}
