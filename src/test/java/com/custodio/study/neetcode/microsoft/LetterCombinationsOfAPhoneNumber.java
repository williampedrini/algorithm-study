package com.custodio.study.neetcode.microsoft;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number">Neet Code</a>
 */
public class LetterCombinationsOfAPhoneNumber
{
    private static final Map<Character, List<String>> DIGIT_TO_LETTER = Map.of(
            '2', List.of("a", "b", "c"),
            '3', List.of("d", "e", "f"),
            '4', List.of("g", "h", "i"),
            '5', List.of("j", "k", "l"),
            '6', List.of("m", "n", "o"),
            '7', List.of("p", "q", "r", "s"),
            '8', List.of("t", "u", "v"),
            '9', List.of("w", "x", "y", "z")
                                                                              );

    @Test
    public void example1()
    {
        //given
        final var digits = "23";
        //when
        final var actual = letterCombinations(digits);
        //then
        final var expected = List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        Assert.assertEquals(expected, actual);
    }

    public List<String> letterCombinations(final String digits)
    {
        final var combinations = new ArrayList<String>();
        solution(0, digits, "", combinations);
        return combinations;
    }

    private void solution(final int currentDigitIndex, final String digits, final String combination, final Collection<String> combinations)
    {
        //If the size of the combinations and the number of digits matches, it means we already have a combination.
        if (combination.length() == digits.length())
        {
            combinations.add(combination);
            return;
        }

        //Now we need to get the current digit and their possible letters.
        final var digit = digits.charAt(currentDigitIndex);
        final var letters = DIGIT_TO_LETTER.getOrDefault(digit, new ArrayList<>());
        for (final var letter : letters)
        {
            solution(currentDigitIndex + 1, digits, combination + letter, combinations);
        }
    }
}

