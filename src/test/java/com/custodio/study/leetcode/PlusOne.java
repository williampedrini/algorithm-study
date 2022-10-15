package com.custodio.study.leetcode;

import org.junit.Test;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;
import static java.lang.String.valueOf;
import static org.junit.Assert.assertArrayEquals;

/**
 * @see <a href="https://leetcode.com/problems/palindrome-number/">Leet Code</a>
 */
public class PlusOne {

    /**
     * WHEN
     * digits = [1,2,3]
     * THEN
     * returns [1,2,4]
     */
    @Test
    public void example1() {
        //given
        final var digits = new int[]{1, 2, 3};
        //when
        final var actual = solution(digits);
        //then
        final var expected = new int[]{1, 2, 4};
        assertArrayEquals(expected, actual);
    }

    /**
     * WHEN
     * digits = [9,8,7,6,5,4,3,2,1,0]
     * THEN
     * returns [1,2,4]
     */
    @Test
    public void example2() {
        //given
        final var digits = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        //when
        final var actual = solution(digits);
        //then
        final var expected = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 1};
        assertArrayEquals(expected, actual);
    }

    public int[] solution(int[] digits) {
        var sum = 0L;
        for (int index = 0, exp = digits.length - 1; index < digits.length; index++, exp--) {
            final var digit = digits[index];
            final var value = digit * pow(10, exp);
            sum += value;
        }
        final var digitsAsString = valueOf(sum + 1);
        final var finalDigits = digitsAsString.toCharArray();
        final var result = new int[finalDigits.length];
        for (var index = 0; index < finalDigits.length; index++) {
            final var digit = finalDigits[index];
            final var digitAsString = valueOf(digit);
            final var digitAsInteger = parseInt(digitAsString);
            result[index] = digitAsInteger;
        }
        return result;
    }
}
