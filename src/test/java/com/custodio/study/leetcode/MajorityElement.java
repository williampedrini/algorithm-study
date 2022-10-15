package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/excel-sheet-column-title/">Leet Code</a>
 */
public class MajorityElement {

    @Test
    public void example1() {
        //given
        final var numbers = new int[]{3, 2, 3};
        //when
        final var actual = solution(numbers);
        //then
        final var expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        //given
        final var numbers = new int[]{2, 2, 1, 1, 1, 2, 2};
        //when
        final var actual = solution(numbers);
        //then
        final var expected = 2;
        assertEquals(expected, actual);
    }

    public int solution(int[] nums) {
        final var quantityPerNumber = new HashMap<Integer, Integer>();
        for (final int number : nums) {
            final var quantity = quantityPerNumber.getOrDefault(number, 0);
            quantityPerNumber.put(number, quantity + 1);
        }
        return quantityPerNumber
                .entrySet()
                .stream()
                .filter(entry -> {
                    final var constant = nums.length / 2;
                    final var quantity = entry.getValue();
                    return quantity > constant;
                })
                .map(Map.Entry::getKey)
                .findAny()
                .orElse(-1);
    }
}
