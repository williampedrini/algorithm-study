package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/count-binary-substrings/">Leet Code</a>
 */
public class CountBinarySubstrings {

    @Test
    public void example1() {
        //given
        final var string = "00110011";
        //when
        final var actual = solution(string);
        //then
        final var expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        //given
        final var string = "10101";
        //when
        final var actual = solution(string);
        //then
        final var expected = 4;
        assertEquals(expected, actual);
    }

    public int solution(final String string) {
        var combinations = new ArrayList<String>();
        solution(combinations, string, 0);
        final var result = new ArrayList<>();
        for (var combination : combinations) {
            if (combination.length() % 2 == 0) {
                final var middleIndex = combination.length() / 2;
                final var firstPart = combination.substring(0, middleIndex);
                final var secondPart = combination.substring(middleIndex);

                if (firstPart.indexOf('0') < 0 || firstPart.indexOf('1') < 0) {
                    result.add(combination);
                    continue;
                }

                var index = firstPart.length() - 1;
                var index2 = 0;
                while (index2 < secondPart.length()) {
                    if (firstPart.charAt(index) != secondPart.charAt(index2)) {
                        break;
                    }
                    index--;
                    index2++;
                }
                if (index == firstPart.length()) {
                    result.add(combination);
                }
            }
        }
        return result.size();
    }

    private void solution(final Collection<String> combinations, final String string, final int begin) {
        if (begin == string.length()) {
            return;
        }
        var quantityByString = new HashMap<Character, Integer>();
        for (var index = begin; index < string.length(); index++) {
            final var number = string.charAt(index);
            final var quantity = quantityByString.getOrDefault(number, 0);
            quantityByString.put(number, quantity + 1);

            final var quantityOfOnes = quantityByString.getOrDefault('1', 0);
            final var quantityOfZeros = quantityByString.getOrDefault('0', 0);
            if (Objects.equals(quantityOfOnes, quantityOfZeros)) {
                final var combination = string.substring(begin, index + 1);
                combinations.add(combination);
            }
        }
        solution(combinations, string, begin + 1);
    }
}
