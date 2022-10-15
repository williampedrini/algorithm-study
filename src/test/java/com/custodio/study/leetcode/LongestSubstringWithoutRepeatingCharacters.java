package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">Leet Code</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {

    @Test
    public void example1() {
        //given
        final var input = "pwwkew";
        //when
        final var actual = lengthOfLongestSubstring(input);
        //then
        final var expected = 3;
        assertEquals(expected, actual);
    }

    public int lengthOfLongestSubstring(final String word) {
        var longestSubstringSize = 0;
        var uniqueLetters = new HashMap<Character, Integer>();
        for (int left = 0, right = 0; right < word.length(); right++) {
            final var rightLetter = word.charAt(right);
            final var rightLetterQuantity = uniqueLetters.getOrDefault(rightLetter, 0) + 1;
            uniqueLetters.put(rightLetter, rightLetterQuantity);

            for (; uniqueLetters.get(rightLetter) > 1; left++) {
                final var leftLetter = word.charAt(left);
                final var leftLetterQuantity = uniqueLetters.getOrDefault(leftLetter, 0) - 1;
                uniqueLetters.put(leftLetter, leftLetterQuantity);
            }
            longestSubstringSize = Math.max(longestSubstringSize, right - left + 1);
        }
        return longestSubstringSize;
    }
}
