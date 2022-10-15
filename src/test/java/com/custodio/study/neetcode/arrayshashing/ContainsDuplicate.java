package com.custodio.study.neetcode.arrayshashing;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/contains-duplicate/">Neet Code</a>
 */
public class ContainsDuplicate {

    public boolean solution(final int[] numbers) {
        final var quantityByNumber = new HashMap<Integer, Integer>();
        for (final int number : numbers) {
            final var quantity = quantityByNumber.getOrDefault(number, 0) + 1;
            quantityByNumber.put(number, quantity);
            if (quantity > 1) {
                return true;
            }
        }
        return false;
    }
}