package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.HashSet;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;
import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/">Leet Code</a>
 */
public class MinimumRemoveToMakeValidParentheses {
    private static final char OPEN = '(';
    private static final char CLOSE = ')';

    @Test
    public void example1() {
        //given
        final var input = "lee(t(c)o)de)";
        //when
        final var actual = solution(input);
        //then
        final var expected = "lee(t(c)o)de";
        assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        //given
        final var input = "))((";
        //when
        final var actual = solution(input);
        //then
        final var expected = "";
        assertEquals(expected, actual);
    }

    public String solution(final String string) {
        final var closeIndexes = new HashSet<Integer>();
        final var openIndexes = new ArrayDeque<Integer>();
        for (var index = 0; index < string.length(); index++) {
            final var character = string.charAt(index);
            if (OPEN == character) {
                openIndexes.push(index);
                continue;
            }
            if (CLOSE == character && openIndexes.isEmpty()) {
                closeIndexes.add(index);
                continue;
            }
            if (CLOSE == character) {
                openIndexes.pop();
            }
        }
        final var resultBuilder = new StringBuilder();
        final var indexes = concat(closeIndexes.stream(), openIndexes.stream()).collect(toList());
        for (var index = 0; index < string.length(); index++) {
            if(indexes.contains(index)) {
                continue;
            }
            final var character = string.charAt(index);
            resultBuilder.append(character);
        }
        return resultBuilder.toString();
    }
}
