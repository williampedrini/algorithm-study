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
        var leftIndex = 0;
        var rightIndex = text.length() - 1;
        while (leftIndex < rightIndex) {
            final var leftCharacter = Character.toLowerCase(text.charAt(leftIndex));
            final var rightCharacter = Character.toLowerCase(text.charAt(rightIndex));
            if (Character.isLetterOrDigit(leftCharacter) && Character.isLetterOrDigit(rightCharacter)) {
                if (leftCharacter == rightCharacter) {
                    leftIndex++;
                    rightIndex--;
                    continue;
                }
                return false;
            }
            if (Character.isLetterOrDigit(leftCharacter)) {
                rightIndex--;
                continue;
            }
            if (Character.isLetterOrDigit(rightCharacter)) {
                leftIndex++;
                continue;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }
}
