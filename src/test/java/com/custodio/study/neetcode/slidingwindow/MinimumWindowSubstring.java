package com.custodio.study.neetcode.slidingwindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/minimum-window-substring/">Neet Code</a>
 */
public class MinimumWindowSubstring {

    @Test
    public void example1() {
        //given
        final var sourceInput = "ADOBECODEBANC";
        final var targetInput = "ABC";
        //when
        final var actual = minWindow(sourceInput, targetInput);
        //then
        final var expected = "BANC";
        assertEquals(expected, actual);
    }

    public String minWindow(final String source, final String target) {
        var leftIndex = 0;
        var rightIndex = source.length();
        {
            var targetLettersFrequency = getFrequencyByLetter(target);
            var sourceSubString = source.substring(leftIndex, rightIndex);
            var sourceSubStringLettersFrequency = getFrequencyByLetter(sourceSubString);
            if (!hasMinimumFrequency(sourceSubStringLettersFrequency, targetLettersFrequency)) {
                return "";
            }
        }
        {
            var targetLettersFrequency = getFrequencyByLetter(target);
            var sourceSubString = source.substring(leftIndex, rightIndex);
            var sourceSubStringLettersFrequency = getFrequencyByLetter(sourceSubString);
            while (hasMinimumFrequency(sourceSubStringLettersFrequency, targetLettersFrequency)) {
                rightIndex--;
                sourceSubString = source.substring(leftIndex, rightIndex);
                sourceSubStringLettersFrequency = getFrequencyByLetter(sourceSubString);
            }
            if (rightIndex < source.length()) {
                rightIndex++;
            }
        }
        {
            var targetLettersFrequency = getFrequencyByLetter(target);
            var sourceSubString = source.substring(leftIndex, rightIndex);
            var sourceSubStringLettersFrequency = getFrequencyByLetter(sourceSubString);
            while (hasMinimumFrequency(sourceSubStringLettersFrequency, targetLettersFrequency)) {
                leftIndex++;
                sourceSubString = source.substring(leftIndex, rightIndex);
                sourceSubStringLettersFrequency = getFrequencyByLetter(sourceSubString);
            }
            if (leftIndex > 0) {
                leftIndex--;
            }
        }
        return source.substring(leftIndex, rightIndex + 1);
    }

    private boolean hasMinimumFrequency(final Map<Character, Integer> source, final Map<Character, Integer> target) {
        for (final var targetEntry : target.entrySet()) {
            final var targetKey = targetEntry.getKey();
            final var targetValue = targetEntry.getValue();
            final var sourceValue = source.getOrDefault(targetKey, 0);
            if (sourceValue < targetValue) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> getFrequencyByLetter(final String text) {
        final var frequencyByLetter = new HashMap<Character, Integer>();
        for (final var letter : text.toCharArray()) {
            final var letterFrequency = frequencyByLetter.getOrDefault(letter, 0);
            frequencyByLetter.put(letter, letterFrequency + 1);
        }

        return frequencyByLetter;
    }
}


