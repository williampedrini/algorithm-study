package com.custodio.study.neetcode.arrayshashing;

import org.junit.Assert;
import org.junit.Test;

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

    public int[] solution(final int[] numbers) {
        return null;
    }
}
