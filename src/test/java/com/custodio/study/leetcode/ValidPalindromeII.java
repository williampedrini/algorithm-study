package com.custodio.study.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @see <a href="https://leetcode.com/problems/valid-palindrome-ii/">Leet Code</a>
 */
public class ValidPalindromeII {

    @Test
    public void example1() {
        //given
        final var word = "abx";
        //when
        final var actual = solution(word);
        //then
        assertFalse(actual);
    }

    @Test
    public void example2() {
        //given
        final var word = "abca";
        //when
        final var actual = solution(word);
        //then
        assertTrue(actual);
    }

    public boolean solution(final String originalWord) {
        for (var index = 0; index < originalWord.length(); index++) {
            final var newWord = new StringBuilder(originalWord).deleteCharAt(index).toString();
            if (isPalindrome(newWord)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPalindrome(final String word) {
        for (int index = 0, index2 = word.length() - 1; index < word.length(); index++, index2--) {
            final var firstLetter = word.charAt(index);
            final var lastLetter = word.charAt(index2);
            if (firstLetter != lastLetter) {
                return false;
            }
        }
        return true;
    }
}
