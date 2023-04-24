package com.custodio.study.neetcode.arrayshashing;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;

/**
 * @see <a href="https://leetcode.com/problems/top-k-frequent-elements/">Neet Code</a>
 */
public class TopKFrequentElements {

    @Test
    public void example1() {
        //given
        final var numbers = new int[]{1, 1, 1, 2, 2, 3};
        //when
        final var actual = solution(numbers, 2);
        //then
        final var expected = new int[]{1, 2};
        assertArrayEquals(expected, actual);
    }

    public int[] solution(final int[] numbers, final int limit) {
        final var quantityByNumber = new HashMap<Integer, Integer>();

        for (final var number : numbers) {
            final var quantity = quantityByNumber.getOrDefault(number, 0);
            quantityByNumber.put(number, quantity + 1);
        }
        return quantityByNumber
                .entrySet()
                .stream()
                .sorted((entry1, entry2) -> {
                    final var quantity1 = entry1.getValue();
                    final var quantity2 = entry2.getValue();
                    return quantity2.compareTo(quantity1);
                })
                .limit(limit)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
