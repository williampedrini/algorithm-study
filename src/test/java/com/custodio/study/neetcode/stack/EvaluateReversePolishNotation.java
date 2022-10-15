package com.custodio.study.neetcode.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/">Neet Code</a>
 */
public class EvaluateReversePolishNotation {

    @Test
    public void example1() {
        //given
        final var characters = new String[]{"2", "1", "+", "3", "*"};
        //when
        final var actual = solution(characters);
        //then
        final var expected = 9;
        assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        //given
        final var characters = new String[]{"4", "13", "5", "/", "+"};
        //when
        final var actual = solution(characters);
        //then
        final var expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        //given
        final var characters = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        //when
        final var actual = solution(characters);
        //then
        final var expected = 22;
        assertEquals(expected, actual);
    }

    public int solution(final String[] characters) {
        return -1;
    }
}
