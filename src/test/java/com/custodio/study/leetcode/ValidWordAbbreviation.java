package com.custodio.study.leetcode;

import org.junit.Test;

import static java.lang.Character.*;
import static java.lang.Integer.parseInt;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @see <a href="https://leetcode.com/problems/valid-word-abbreviation/">Leet Code</a>
 */
public class ValidWordAbbreviation {

    @Test
    public void example1() {
        //given
        final var word = "internationalization";
        final var abbreviation = "i12iz4n";
        //when
        final var actual = solution(word, abbreviation);
        //then
        assertTrue(actual);
    }

    @Test
    public void example2() {
        //given
        final var word = "apple";
        final var abbreviation = "a2e";
        //when
        final var actual = solution(word, abbreviation);
        //then
        assertFalse(actual);
    }

    @Test
    public void example3() {
        //given
        final var word = "apple";
        final var abbreviation = "a0pple";
        //when
        final var actual = solution(word, abbreviation);
        //then
        assertFalse(actual);
    }

    @Test
    public void example4() {
        //given
        final var word = "internationalization";
        final var abbreviation = "i5a11o1";
        //when
        final var actual = solution(word, abbreviation);
        //then
        assertTrue(actual);
    }

    @Test
    public void example5() {
        //given
        final var word = "a";
        final var abbreviation = "a";
        //when
        final var actual = solution(word, abbreviation);
        //then
        assertTrue(actual);
    }

    @Test
    public void example6() {
        //given
        final var word = "hi";
        final var abbreviation = "2i";
        //when
        final var actual = solution(word, abbreviation);
        //then
        assertFalse(actual);
    }

    @Test
    public void example7() {
        //given
        final var word = "a";
        final var abbreviation = "1";
        //when
        final var actual = solution(word, abbreviation);
        //then
        assertTrue(actual);
    }

    @Test
    public void example8() {
        //given
        final var word = "a";
        final var abbreviation = "2";
        //when
        final var actual = solution(word, abbreviation);
        //then
        assertFalse(actual);
    }

    @Test
    public void example9() {
        //given
        final var word = "cccc";
        final var abbreviation = "c2ca";
        //when
        final var actual = solution(word, abbreviation);
        //then
        assertFalse(actual);
    }

    public boolean solution(final String word, final String abbreviation) {
        if (word.isBlank() || word.equals(abbreviation)) {
            return true;
        }

        var wordIndex = 0;
        var abbreviationIndex = 0;
        while (wordIndex < word.length() && abbreviationIndex < abbreviation.length()) {
            var currentAbbreviationCharacter = abbreviation.charAt(abbreviationIndex);
            var currentWordCharacter = word.charAt(wordIndex);

            if (isDigit(currentAbbreviationCharacter) && currentAbbreviationCharacter != '0') {
                final var numberBuilder = new StringBuilder();
                while (abbreviationIndex < abbreviation.length() && isDigit(abbreviation.charAt(abbreviationIndex))) {
                    numberBuilder.append(abbreviation.charAt(abbreviationIndex));
                    abbreviationIndex++;
                }
                wordIndex = parseInt(numberBuilder.toString()) + wordIndex;
                continue;
            }

            if (currentWordCharacter == currentAbbreviationCharacter) {
                abbreviationIndex++;
                wordIndex++;
            } else {
                return false;
            }
        }

        return wordIndex == word.length() && abbreviationIndex == abbreviation.length();
    }
}















