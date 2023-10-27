package com.custodio.study.neetcode.twopointers;

import org.junit.Test;

import java.util.*;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/3sum/">Neet Code</a>
 */
public class ThreeSum {

    @Test
    public void example1() {
        //given
        final var input = new int[]{-1, 0, 1, 2, -1, -4};
        //when
        final var actual = solution(input);
        //then
        final var expected = asList(asList(-1, -1, 2), asList(-1, 0, 1));
        assertEquals(expected, actual);
    }

    public List<List<Integer>> solution(final int[] numbers) {
        // We want to sort it to avoid duplications in terms of possible combinations.
        Arrays.sort(numbers);

        final var results = new HashSet<List<Integer>>();

        for (var index = 0; index < numbers.length; index++) {
            final var number = numbers[index];
            if (index > 0 && number == numbers[index - 1]) {
                continue;
            }
            final var subNumbersArray = Arrays.copyOfRange(numbers, index + 1, numbers.length);
            results.addAll(solution(subNumbersArray, number * -1));
        }
        return new ArrayList<>(results);
    }

    private List<List<Integer>> solution(final int[] numbers, final int target) {
        var leftIndex = 0;
        var rightIndex = numbers.length - 1;
        var results = new ArrayList<List<Integer>>();
        while (leftIndex < rightIndex) {
            final var left = numbers[leftIndex];
            final var right = numbers[rightIndex];
            if (left + right == target) {
                final var result = Arrays.asList(target * -1, left, right);
                results.add(result);
                leftIndex++;
                continue;
            }
            if (left + right > target) {
                rightIndex--;
                continue;
            }
            leftIndex++;
        }
        return results;
    }
}
