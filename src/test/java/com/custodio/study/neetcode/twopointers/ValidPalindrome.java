package com.custodio.study.neetcode.twopointers;

import org.junit.Test;

import static java.lang.Character.*;
import static org.junit.Assert.assertTrue;

/**
 * @see <a href="https://leetcode.com/problems/valid-palindrome/">Neet Code</a>
 */
public class ValidPalindrome {

    @Test
    public void example1() {
        //given
        final var text = ".;";
        //when
        final var actual = solution(text);
        //then
        assertTrue(actual);
    }

    public boolean solution(final String text) {
        for (int left = 0, right = text.length() - 1; left < right; left++, right--) {
            while (left < text.length() - 1 && !isLetterOrDigit(text.charAt(left))) {
                left++;
            }
            while (right > 0 && !isLetterOrDigit(text.charAt(right))) {
                right--;
            }
            final var leftCharacter = toLowerCase(text.charAt(left));
            final var rightCharacter = toLowerCase(text.charAt(right));
            final var isSameCharacter = leftCharacter == rightCharacter;
            if (isLetterOrDigit(leftCharacter) && isLetterOrDigit(rightCharacter) && isSameCharacter) {
                continue;
            }
            return !isLetterOrDigit(leftCharacter) && !isLetterOrDigit(rightCharacter);
        }
        return true;
    }
}
