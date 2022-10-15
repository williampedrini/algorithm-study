package com.custodio.study.leetcode;

import org.junit.Test;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import static java.lang.Character.toLowerCase;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @see <a href="https://leetcode.com/problems/valid-palindrome/">Leet Code</a>
 */
public class ValidPalindrome {

    @Test
    public void example1() {
        //given
        final var phrase = "A man, a plan, a canal: Panama";
        //when
        final var actual = solution(phrase);
        //then
        assertTrue(actual);
    }

    @Test
    public void example2() {
        //given
        final var phrase = ".,";
        //when
        final var actual = solution(phrase);
        //then
        assertTrue(actual);
    }

    @Test
    public void example3() {
        //given
        final var phrase = "0P";
        //when
        final var actual = solution(phrase);
        //then
        assertFalse(actual);
    }

    public boolean solution(final String phrase) {
        var left = 0;
        var right = phrase.length() - 1;
        while (left < right) {
            final var leftLetter = phrase.charAt(left);
            final var rightLetter = phrase.charAt(right);
            final var isLeftLetterAlphanumeric = isLetter(leftLetter) || isDigit(leftLetter);
            final var isRightLetterAlphanumeric = isLetter(rightLetter) || isDigit(rightLetter);
            if (isLeftLetterAlphanumeric && isRightLetterAlphanumeric) {
                final var lowerCasedLeftLetter = toLowerCase(leftLetter);
                final var lowerCasedRightLetter = toLowerCase(rightLetter);
                if (lowerCasedLeftLetter == lowerCasedRightLetter) {
                    right--;
                    left++;
                    continue;
                }
                return false;
            }
            if (isLeftLetterAlphanumeric) {
                right--;
                continue;
            }
            if (isRightLetterAlphanumeric) {
                left++;
                continue;
            }
            right--;
            left++;
        }
        return true;
    }
}
