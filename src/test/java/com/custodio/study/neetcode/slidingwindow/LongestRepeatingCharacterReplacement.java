package com.custodio.study.neetcode.slidingwindow;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/longest-repeating-character-replacement/">Neet Code</a>
 */
public class LongestRepeatingCharacterReplacement {

    @Test
    public void example1() {
        //given
        final var input = "AABABBA";
        final var replacements = 1;
        //when
        final var actual = characterReplacement(input, replacements);
        //then
        final var expected = 4;
        Assert.assertEquals(expected, actual);
    }

    public int characterReplacement(final String text, final int replacements) {
        //We need to know how many occurrences for the same character exist.
        final var amountByCharacter = new HashMap<Character, Integer>();

        var leftIndex = 0;
        var rightIndex = 0;
        var longestSize = 0;
        while (rightIndex < text.length()) {
            final var rightCharacter = text.charAt(rightIndex);
            final var rightCharacterRepetitions = amountByCharacter.getOrDefault(rightCharacter, 0);
            amountByCharacter.put(rightCharacter, rightCharacterRepetitions + 1);

            //We need to take the character the has the highest occurrence and subtract by the current window length.
            //If this difference is less or equal to the maximum allowed replacements, this is a valid substring.
            final var size = rightIndex - leftIndex + 1;
            final var maximumAmountOfRepetition = amountByCharacter.values()
                    .stream()
                    .mapToInt(amount -> amount)
                    .max()
                    .orElse(0);
            if (size - maximumAmountOfRepetition <= replacements) {
                longestSize = Math.max(longestSize, size);
                rightIndex++;
                continue;
            }
            final var leftCharacter = text.charAt(leftIndex);
            final var leftCharacterRepetition = amountByCharacter.get(leftCharacter);
            amountByCharacter.put(leftCharacter, leftCharacterRepetition - 1);
            leftIndex++;
            rightIndex++;
        }
        return longestSize;
    }
}
