package com.custodio.study.neetcode.slidingwindow;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">Neet Code</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {

    @Test
    public void example1() {
        //given
        final var input = "abcabcbb";
        //when
        final var actual = solution(input);
        //then
        final var expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        //given
        final var input = "bbbbb";
        //when
        final var actual = solution(input);
        //then
        final var expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        //given
        final var input = "pwwkew";
        //when
        final var actual = solution(input);
        //then
        final var expected = 3;
        assertEquals(expected, actual);
    }

    public int solution(final String text) {
        var letters = new HashSet<Character>();
        var leftIndex = 0;
        var rightIndex = 0;
        var maxSize = 0;
        while (rightIndex < text.length()) {
            while (letters.contains(text.charAt(rightIndex))) {
                final var letter = text.charAt(leftIndex);
                letters.remove(letter);
                leftIndex++;
            }
            final var letter = text.charAt(rightIndex);
            letters.add(letter);

            final var currentSize = rightIndex - leftIndex + 1;
            maxSize = Math.max(maxSize, currentSize);

            rightIndex++;
        }
        return maxSize;
    }
}
