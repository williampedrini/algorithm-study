package com.custodio.study.leetcode;

import org.junit.Test;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
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
        if (word.length() < abbreviation.length()) {
            return false;
        }

        var wordIndex = 0;
        var abbreviationIndex = 0;
        var abbreviationNumberBuilder = new StringBuilder();
        while (wordIndex < word.length() && abbreviationIndex < abbreviation.length()) {

            final var abbreviationCharacter = abbreviation.charAt(abbreviationIndex);
            if (isLetter(abbreviationCharacter)) {
                final var abbreviationNumber = abbreviationNumberBuilder.toString();
                if (!abbreviationNumber.isEmpty()) {
                    wordIndex += parseInt(abbreviationNumber);
                    abbreviationNumberBuilder = new StringBuilder();
                }

                if (wordIndex < word.length() && word.charAt(wordIndex) == abbreviationCharacter) {
                    wordIndex++;
                    abbreviationIndex++;
                    continue;
                }
                return false;
            }

            if (isDigit(abbreviationCharacter)) {
                if (abbreviationIndex == 0 && abbreviationCharacter == '0') {
                    return false;
                }
                if (abbreviationIndex > 0 && isLetter(abbreviation.charAt(abbreviationIndex - 1)) && abbreviationCharacter == '0') {
                    return false;
                }
                abbreviationNumberBuilder.append(abbreviationCharacter);
                abbreviationIndex++;
            }
        }

        final var abbreviationNumber = abbreviationNumberBuilder.toString();
        if (wordIndex < word.length() && abbreviationNumber.isEmpty()) {
            return false;
        }
        final var missingCharactersToRead = word.length() - wordIndex;
        if (wordIndex < word.length() && parseInt(abbreviationNumber) != missingCharactersToRead) {
            return false;
        }

        if (abbreviationIndex == abbreviation.length() - 1) {
            final var abbreviationCharacter = abbreviation.charAt(abbreviationIndex);
            final var wordCharacter = word.charAt(wordIndex - 1);
            return abbreviationCharacter == wordCharacter;
        }
        return true;
    }
}















