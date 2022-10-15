package com.custodio.study.leetcode;

import org.junit.Test;

import static java.lang.String.valueOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @see <a href="https://leetcode.com/problems/palindrome-number/">Leet Code</a>
 */
public class PalindromeNumber {

    /**
     * WHEN
     * number = 121
     * THEN
     * returns true
     */
    @Test
    public void example1() {
        //when
        final var actual = solution(121);
        //then
        assertTrue(actual);
    }

    /**
     * WHEN
     * number = -121
     * THEN
     * returns false
     */
    @Test
    public void example2() {
        //when
        final var actual = solution(-121);
        //then
        assertFalse(actual);
    }

    /**
     * WHEN
     * number = 10
     * THEN
     * returns false
     */
    @Test
    public void example3() {
        //when
        final var actual = solution(10);
        //then
        assertFalse(actual);
    }

    public boolean solution(final int number) {
        var numberAsString = valueOf(number);
        var start = 0;
        var end = numberAsString.length() - 1;
        while (start < end) {
            final var startNumber = numberAsString.charAt(start);
            final var endNumber = numberAsString.charAt(end);
            if (startNumber == endNumber) {
                start++;
                end--;
                continue;
            }
            return false;
        }
        return true;
    }
}
