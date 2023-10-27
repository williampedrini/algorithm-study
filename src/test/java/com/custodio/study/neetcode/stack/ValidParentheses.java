package com.custodio.study.neetcode.stack;

import org.junit.Test;

import java.util.ArrayDeque;

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

        final var expressions = new ArrayDeque<Character>();

        for (final var character : text.toCharArray()) {
            if (isOpenToken(character)) {
                expressions.push(character);
                continue;
            }
            if (expressions.isEmpty()) {
                return false;
            }
            final var openToken = expressions.pop();
            if (isCloseToken(character) && isValidCloseToken(openToken, character)) {
                continue;
            }
            return false;
        }
        return expressions.isEmpty();
    }

    private boolean isCloseToken(final Character character) {
        for (final var token : VALID_TOKENS) {
            if (token[1] == character) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidCloseToken(final Character openToken, final Character closeToken) {
        for (final var token : VALID_TOKENS) {
            if (token[0] == openToken) {
                return token[1] == closeToken;
            }
        }
        return false;
    }

    private boolean isOpenToken(final Character character) {
        for (final var token : VALID_TOKENS) {
            if (token[0] == character) {
                return true;
            }
        }
        return false;
    }
}
