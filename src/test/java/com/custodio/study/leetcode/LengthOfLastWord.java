package com.custodio.study.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/length-of-last-word/">Leet Code</a>
 */
public class LengthOfLastWord {

    /**
     * WHEN
     * string = "Hello World"
     * THEN
     * returns 5
     */
    @Test
    public void example1() {
        //given
        final var phrase = "Hello World";
        //when
        final var actual = solution(phrase);
        //then
        final var expected = 5;
        assertEquals(expected, actual);
    }

    /**
     * WHEN
     * string = "   fly me   to   the moon  "
     * THEN
     * returns 4
     */
    @Test
    public void example2() {
        //given
        final var phrase = "   fly me   to   the moon  ";
        //when
        final var actual = solution(phrase);
        //then
        final var expected = 4;
        assertEquals(expected, actual);
    }

    /**
     * WHEN
     * string = "luffy is still joyboy"
     * THEN
     * returns 6
     */
    @Test
    public void example3() {
        //given
        final var phrase = "luffy is still joyboy";
        //when
        final var actual = solution(phrase);
        //then
        final var expected = 6;
        assertEquals(expected, actual);
    }

    /**
     * WHEN
     * string = "a"
     * THEN
     * returns 1
     */
    @Test
    public void example4() {
        //given
        final var phrase = "a";
        //when
        final var actual = solution(phrase);
        //then
        final var expected = 1;
        assertEquals(expected, actual);
    }

    /**
     * WHEN
     * string = "day"
     * THEN
     * returns 3
     */
    @Test
    public void example5() {
        //given
        final var phrase = "day";
        //when
        final var actual = solution(phrase);
        //then
        final var expected = 3;
        assertEquals(expected, actual);
    }

    /**
     * WHEN
     * string = " a"
     * THEN
     * returns 1
     */
    @Test
    public void example6() {
        //given
        final var phrase = " a";
        //when
        final var actual = solution(phrase);
        //then
        final var expected = 1;
        assertEquals(expected, actual);
    }

    public int solution(final String phrase) {
        var index = phrase.length() - 1;
        while (index > 0 && phrase.charAt(index) == ' ') {
            index--;
        }

        var length = 0;
        while (index >= 0 && phrase.charAt(index) != ' ') {
            index--;
            length++;
        }
        return length;
    }
}
