package com.custodio.study.leetcode;

import org.junit.Test;

import static java.lang.Math.pow;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @see <a href="https://leetcode.com/problems/happy-number/">Leet Code</a>
 */
public class HappyNumber {

    @Test
    public void example1() {
        //given
        final var number = 19;
        //when
        final var actual = isHappy(number);
        //then
        assertTrue(actual);
    }

    @Test
    public void example2() {
        //given
        final var number = 2;
        //when
        final var actual = isHappy(number);
        //then
        assertFalse(actual);
    }

    @Test
    public void example3() {
        //given
        final var number = 1;
        //when
        final var actual = isHappy(number);
        //then
        assertTrue(actual);
    }

    @Test
    public void example4() {
        //given
        final var number = 4;
        //when
        final var actual = isHappy(number);
        //then
        assertTrue(actual);
    }

    public boolean isHappy(final int number) {
        var sum = 0;
        var index = 0;
        var numberAsString = String.valueOf(number);
        while (index < numberAsString.length()) {
            final var digitAsCharacter = numberAsString.charAt(index);
            final var digit = Character.getNumericValue(digitAsCharacter);
            sum += pow(digit, 2);
            if (sum == 1) {
                return true;
            }
            if (index == numberAsString.length() - 1 && sum > pow(2, 31) - 1) {
                return false;
            }
            if (index == numberAsString.length() - 1 && sum <= pow(2, 31) - 1) {
                index = 0;
                numberAsString = String.valueOf(sum);
            }
            index++;
        }
        return sum == 1;
    }
}
