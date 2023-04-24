package com.custodio.study.neetcode.stack;

import org.junit.Test;

import java.util.Stack;

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

    public boolean isValid(final String expression) {
        final var expressions = new Stack<Character>();
        for (final var character : expression.toCharArray()) {
            if (isOpeningSymbol(character)) {
                expressions.push(character);
            }
            if (isClosingSymbol(character)) {
                if (expressions.isEmpty()) {
                    return false;
                }
                final var openSymbol = expressions.pop();
                if (isNotExpectedClosingSymbol(character, openSymbol)) {
                    return false;
                }
            }
        }
        return expressions.isEmpty();
    }

    public boolean isNotExpectedClosingSymbol(final Character actualCloseSymbol, final Character expectedOpenSymbol) {
        return !isExpectedClosingSymbol(actualCloseSymbol, expectedOpenSymbol);
    }

    public boolean isExpectedClosingSymbol(final Character actualCloseSymbol, final Character expectedOpenSymbol) {
        for (final var token : VALID_TOKENS) {
            final var openSymbol = token[0];
            if (expectedOpenSymbol == openSymbol) {
                final var expectedCloseSymbol = token[1];
                return actualCloseSymbol == expectedCloseSymbol;
            }
        }
        return false;
    }

    public boolean isClosingSymbol(final Character character) {
        for (final var token : VALID_TOKENS) {
            final var symbol = token[1];
            if (character == symbol) {
                return true;
            }
        }
        return false;
    }

    public boolean isOpeningSymbol(final Character character) {
        for (final var token : VALID_TOKENS) {
            final var symbol = token[0];
            if (character == symbol) {
                return true;
            }
        }
        return false;
    }
}
