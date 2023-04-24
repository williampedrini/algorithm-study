package com.custodio.study.neetcode.arrayshashing;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;

import static java.util.Optional.ofNullable;

/**
 * @see <a href="https://leetcode.com/problems/product-of-array-except-self/">Neet Code</a>
 */
public class ProductOfArrayExceptSelf {

    @Test
    public void example1() {
        //given
        final var input = new int[]{2, 3, 5, 0};
        //when
        final var actual = solution(input);
        //then
        final var expected = new int[]{0, 0, 0, 30};
        Assert.assertArrayEquals(expected, actual);
    }

    public int[] solution(final int[] nums) {
        //1: Calculate the prefix of each number
        final var prefixes = new ArrayList<Integer>();
        for (var index = 0; index < nums.length; index++) {
            final var number = nums[index];
            if (index > 0) {
                final var previousPrefix = prefixes.get(index - 1);
                final var currentPrefix = previousPrefix * number;
                prefixes.add(currentPrefix);
                continue;
            }
            prefixes.add(number);
        }
        //2: Calculate the postfix of each number
        final var postfixes = new ArrayDeque<Integer>();

        for (var index = nums.length - 1; index > -1; index--) {
            final var number = nums[index];
            final var previousPrefix = ofNullable(postfixes.peek()).orElse(1);
            final var currentPrefix = previousPrefix * number;
            postfixes.push(currentPrefix);
        }
        //3: Multiply the prefix and postfix of each number.
        final var postfixesArray = new ArrayList<>(postfixes);
        final var results = new ArrayList<Integer>();
        for (var index = 0; index < nums.length; index++) {
            final var prefix = index == 0 ? 1 : prefixes.get(index - 1);
            final var postfix = index == nums.length - 1 ? 1 : postfixesArray.get(index + 1);
            final var result = prefix * postfix;
            results.add(result);
        }
        return results
                .stream()
                .mapToInt(number -> number)
                .toArray();
    }
}
