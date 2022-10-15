package com.custodio.study.neetcode.twopointers;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @see <a href="https://leetcode.com/problems/valid-palindrome/">Neet Code</a>
 */
public class ValidPalindrome {

    @Test
    public void example1() {
        //given
        final var text = "A man, a plan, a canal: Panama";
        //when
        final var actual = solution(text);
        //then
        assertTrue(actual);
    }

    public boolean solution(final String text) {
        return false;
    }
}
