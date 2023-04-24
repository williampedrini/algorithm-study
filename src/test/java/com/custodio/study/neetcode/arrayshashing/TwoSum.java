package com.custodio.study.neetcode.arrayshashing;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/two-sum/">Neet Code</a>
 */
public class TwoSum {

    public int[] solution(final int[] numbers, final int target) {
        final var numberByIndex = new HashMap<Integer, Integer>();
        for (var index = 0; index < numbers.length; index++) {
            final var number = numbers[index];
            final var difference = target - number;
            final var differenceIndex = numberByIndex.getOrDefault(difference, -1);
            if (differenceIndex >= 0) {
                return new int[] {differenceIndex, index};
            }
            numberByIndex.put(number, index);
        }
        return null;
    }
}
