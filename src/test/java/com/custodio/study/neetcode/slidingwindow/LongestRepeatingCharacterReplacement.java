package com.custodio.study.neetcode.slidingwindow;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/longest-repeating-character-replacement/">Neet Code</a>
 */
public class LongestRepeatingCharacterReplacement {

    @Test
    public void example1() {
        //given
        final var input = "ABAA";
        //when
        final var actual = solution(input, 0);
        //then
        final var expected = 2;
        assertEquals(expected, actual);
    }

    public int solution(final String text, final int limit) {
        var frequencyByLetter = new HashMap<Character, Integer>();
        var result = 0;
        var leftIndex = 0;
        var maximumFrequency = 0;

        for (var rightIndex = 0; rightIndex < text.length(); rightIndex++) {
            final var letter = text.charAt(rightIndex);
            final var letterFrequency = frequencyByLetter.getOrDefault(letter, 0);
            frequencyByLetter.put(letter, letterFrequency + 1);

            maximumFrequency = Math.max(maximumFrequency, letterFrequency);

            while (leftIndex < rightIndex && (rightIndex - leftIndex + 1) - maximumFrequency > limit) {
                final var leftLetter = text.charAt(leftIndex);
                final var leftLetterFrequency = frequencyByLetter.get(leftLetter);
                frequencyByLetter.put(leftLetter, leftLetterFrequency - 1);
                leftIndex++;
            }

            result = Math.max(result, (rightIndex - leftIndex + 1));
        }
        return result;
    }
}
