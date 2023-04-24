package com.custodio.study.neetcode.stack;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/generate-parentheses/">Neet Code</a>
 */
public class GenerateParentheses {

    @Test
    public void example1() {
        //given
        final var numberOfPairs = 3;
        //when
        final var actual = generateParenthesis(numberOfPairs);
        //then
        final var expected = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
        assertEquals(expected, actual);
    }

    public List<String> generateParenthesis(final int numberOfPairs) {
        final var parenthesis = new Stack<String>();
        generateParenthesis(numberOfPairs, 0, 0, parenthesis, new Stack<>());
        return new ArrayList<>(parenthesis);
    }

    public void generateParenthesis(final int numberOfPairs,
                                    final int openSymbols,
                                    final int closeSymbols,
                                    final Stack<String> expressions,
                                    final Stack<String> expressionBuilder) {
        if (openSymbols == numberOfPairs && closeSymbols == numberOfPairs) {
            final var expression = String.join("", expressionBuilder);
            expressions.push(expression);
            return;
        }
        if (openSymbols < numberOfPairs) {
            expressionBuilder.push("(");
            generateParenthesis(numberOfPairs, openSymbols + 1, closeSymbols, expressions, expressionBuilder);
            expressionBuilder.pop();
        }
        if (closeSymbols < openSymbols) {
            expressionBuilder.push(")");
            generateParenthesis(numberOfPairs, openSymbols, closeSymbols + 1, expressions, expressionBuilder);
            expressionBuilder.pop();
        }
    }
}
