package com.custodio.study.neetcode.twopointers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.*;
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

    public List<List<Integer>> solution(final int[] numbersArray) {
        sort(numbersArray);

        final var result = new ArrayDeque<List<Integer>>();

        for (var index = 0; index < numbersArray.length; index++) {
            if (index > 0) {
                final var previousNumber = numbersArray[index - 1];
                final var currentNumber = numbersArray[index];
                if (previousNumber == currentNumber) {
                    continue;
                }
                final var subNumbers = stream(numbersArray)
                        .sorted()
                        .boxed()
                        .collect(Collectors.toCollection(LinkedList::new));
                subNumbers.remove(index);
                final var subNumbersArray = subNumbers
                        .stream()
                        .mapToInt(number -> number)
                        .toArray();
                final var solution = solution(subNumbersArray, currentNumber * -1);
                if (solution.isEmpty()) {
                    continue;
                }
                solution.addFirst(currentNumber);
                result.add(new ArrayList<>(solution));
            } else {
                final var currentNumber = numbersArray[index];
                final var subNumbers = stream(numbersArray)
                        .sorted()
                        .boxed()
                        .collect(Collectors.toCollection(LinkedList::new));
                subNumbers.remove(index);
                final var subNumbersArray = subNumbers
                        .stream()
                        .mapToInt(number -> number)
                        .toArray();
                final var solution = solution(subNumbersArray, currentNumber * -1);
                if (solution.isEmpty()) {
                    continue;
                }
                solution.addFirst(currentNumber);
                result.add(new ArrayList<>(solution));
            }
        }

        return new ArrayList<>(result);
    }

    public Deque<Integer> solution(final int[] numbersArray, final int target) {
        var leftIndex = 0;
        var rightIndex = numbersArray.length - 1;
        while (leftIndex < rightIndex) {
            final var left = numbersArray[leftIndex];
            final var right = numbersArray[rightIndex];
            if (left + right == target) {
                final var result = new ArrayDeque<Integer>();
                result.add(left);
                result.add(right);
                return result;
            }
            if (left + right < target) {
                leftIndex++;
            }
            if (left + right > target) {
                rightIndex--;
            }
        }
        return new ArrayDeque<>();
    }
}
