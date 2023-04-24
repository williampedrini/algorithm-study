package com.custodio.study.neetcode.slidingwindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @see <a href="https://leetcode.com/problems/permutation-in-string/">Neet Code</a>
 */
public class PermutationInString {

    @Test
    public void example1() {
        //given
        final var inputSource = "adc";
        final var inputTarget = "dcda";
        //when
        final var actual = checkInclusion(inputSource, inputTarget);
        //then
        assertTrue(actual);
    }

    @Test
    public void example2() {
        //given
        final var inputSource = "ab";
        final var inputTarget = "eidbaooo";
        //when
        final var actual = checkInclusion(inputSource, inputTarget);
        //then
        assertTrue(actual);
    }

    @Test
    public void example3() {
        //given
        final var inputSource = "ab";
        final var inputTarget = "eidboaoo";
        //when
        final var actual = checkInclusion(inputSource, inputTarget);
        //then
        assertFalse(actual);
    }

    public boolean checkInclusion(final String source, final String target) {
        final var sourceQuantityByLetter = calculateFrequencyByLetter(source);
        for (var index = 0; index + source.length() - 1 < target.length(); index++) {
            final var subString = target.substring(index, index + source.length());
            final var subStringFrequencyByLetter = calculateFrequencyByLetter(subString);
            if (sourceQuantityByLetter.equals(subStringFrequencyByLetter)) {
                return true;
            }
        }
        return false;
    }

    private Map<Character, Integer> calculateFrequencyByLetter(final String text) {
        final var quantityByLetter = new HashMap<Character, Integer>();
        for (final var letter : text.toCharArray()) {
            final var quantity = quantityByLetter.getOrDefault(letter, 0);
            quantityByLetter.put(letter, quantity + 1);
        }
        return quantityByLetter;
    }
}
