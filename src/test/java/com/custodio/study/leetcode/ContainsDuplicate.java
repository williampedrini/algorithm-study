package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @see <a href="https://leetcode.com/problems/contains-duplicate/">Leet Code</a>
 */
public class ContainsDuplicate {

    @Test
    public void example1() {
        //given
        final var numbers = new int[]{1, 2, 3, 1};
        //when
        final var actual = solution(numbers);
        //then
        assertTrue(actual);
    }

    @Test
    public void example2() {
        //given
        final var numbers = new int[]{1, 2, 3};
        //when
        final var actual = solution(numbers);
        //then
        assertFalse(actual);
    }

    public boolean solution(final int[] numbers) {
        final var quantityByNumber = new HashMap<Integer, Integer>();
        for (final int number : numbers) {
            final var quantity = quantityByNumber.getOrDefault(number, 0);
            quantityByNumber.put(number, quantity + 1);
        }
        return quantityByNumber
                .values()
                .stream()
                .anyMatch(value -> value >= 2);
    }
}
