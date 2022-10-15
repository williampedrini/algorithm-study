package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParentheses {

    private static final Collection<Expression> VALID_EXPRESSIONS = Set.of(
            new Expression('(', ')'),
            new Expression('{', '}'),
            new Expression('[', ']')
    );

    /**
     * WHEN
     * expression = "()
     * THEN
     * returns true
     */
    @Test
    public void example1() {
        //when
        final var actual = solution("()");
        //then
        assertTrue(actual);
    }

    /**
     * WHEN
     * expression = "()[]{}"
     * THEN
     * returns true
     */
    @Test
    public void example2() {
        //when
        final var actual = solution("()[]{}");
        //then
        assertTrue(actual);
    }

    /**
     * WHEN
     * expression = "(]"
     * THEN
     * returns false
     */
    @Test
    public void example3() {
        //when
        final var actual = solution("(]");
        //then
        assertFalse(actual);
    }

    public boolean solution(final String expression) {
        final var characters = new ArrayDeque<Character>();
        for (var character : expression.toCharArray()) {
            if (isOpenExpression(character)) {
                characters.push(character);
                continue;
            }
            if(characters.isEmpty()) {
                return false;
            }
            final var previousOpenExpression = characters.pop();
            if (!isCloseExpression(previousOpenExpression, character)) {
                return false;
            }
        }
        return characters.isEmpty();
    }

    private boolean isOpenExpression(final char expression) {
        for (final var validExpression : VALID_EXPRESSIONS) {
            if (validExpression.matchesOpenExpression(expression)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCloseExpression(final char openExpression, final char closeExpression) {
        for (final var validExpression : VALID_EXPRESSIONS) {
            if (validExpression.matchesCloseExpression(closeExpression)) {
                return validExpression.matchesOpenExpression(openExpression);
            }
        }
        return false;
    }

    private static class Expression {
        private final char open;
        private final char close;

        private Expression(final char open, final char close) {
            this.open = open;
            this.close = close;
        }

        private boolean matchesOpenExpression(final char expression) {
            return open == expression;
        }

        private boolean matchesCloseExpression(final char expression) {
            return close == expression;
        }
    }
}
