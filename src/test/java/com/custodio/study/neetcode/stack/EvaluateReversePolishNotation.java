package com.custodio.study.neetcode.stack;

import org.junit.Test;

import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

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
        final var operations = Map.of(
                "+", Integer::sum,
                "-", (number1, number2) -> number1 - number2,
                "*", (number1, number2) -> number2 * number1,
                "/", (BiFunction<Integer, Integer, Integer>) (number1, number2) -> number2 / number1
        );
        final var numbers = new Stack<Integer>();
        for (final var character : characters) {
            final var operation = operations.get(character);
            if (operation == null) {
                numbers.push(Integer.valueOf(character));
                continue;
            }
            final var number1 = numbers.pop();
            final var number2 = numbers.pop();
            final var result = operation.apply(number1, number2);
            numbers.push(result);
        }
        return numbers.pop();
    }
}
