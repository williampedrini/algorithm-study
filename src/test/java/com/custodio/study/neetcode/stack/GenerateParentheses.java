package com.custodio.study.neetcode.stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        return null;
    }
}
