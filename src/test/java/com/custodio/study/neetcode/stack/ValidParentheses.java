package com.custodio.study.neetcode.stack;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @see <a href="https://leetcode.com/problems/valid-parentheses/">Neet Code</a>
 */
public class ValidParentheses {

    private static final char[][] VALID_TOKENS = new char[][]{
            {'(', ')'},
            {'{', '}'},
            {'[', ']'}
    };

    @Test
    public void example1() {
        //given
        final var text = "()";
        //when
        final var actual = isValid(text);
        //then
        assertTrue(actual);
    }

    @Test
    public void example2() {
        //given
        final var text = "()[]{}";
        //when
        final var actual = isValid(text);
        //then
        assertTrue(actual);
    }

    @Test
    public void example3() {
        //given
        final var text = "(]";
        //when
        final var actual = isValid(text);
        //then
        assertFalse(actual);
    }

    @Test
    public void example4() {
        //given
        final var text = "(";
        //when
        final var actual = isValid(text);
        //then
        assertFalse(actual);
    }

    public boolean isValid(final String text) {
        return false;
    }
}
