package com.custodio.study.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/sqrtx/">Leet Code</a>
 */
public class SqrtOfX {

    @Test
    public void example1() {
        //given
        final var input = 36;
        //when
        final var actual = solution(input);
        //then
        final var expected = 6;
        assertEquals(expected, actual);
    }

    public int solution(final int number) {
        if(number < 2) {
            return number;
        }
        var left = 2;
        var right = number / 2;
        while (left < right) {
            final var middle = left + (right - left) / 2;
            if (middle * middle == number) {
                return middle;
            }
            if (middle * middle < number) {
                left = middle + 1;
                right--;
            }
            if(middle * middle > number) {
                left++;
                right = middle - 1;
            }
        }
        return right;
    }
}
