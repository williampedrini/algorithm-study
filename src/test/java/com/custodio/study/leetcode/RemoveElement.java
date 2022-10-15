package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;
import static java.util.Arrays.sort;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class RemoveElement {

    /**
     * WHEN
     * numbers = [3,2,2,3], val = 3
     * THEN
     * returns = 2, nums = [2,2,_,_]
     */
    @Test
    public void example1() {
        //given
        final var input = new Integer[]{3, 2, 2, 3};
        //when
        final var actualIndex = solution(input, 3);
        //then
        final var actual = stream(input).limit(actualIndex).collect(toList());
        final var expected = asList(2, 2);
        assertEquals(expected, actual);
    }

    /**
     * WHEN
     * numbers = [0,1,2,2,3,0,4,2], val = 2
     * THEN
     * returns = 5, nums = [0,1,4,0,3,_,_,__]
     */
    @Test
    public void example2() {
        //given
        final var input = new Integer[]{0, 1, 2, 2, 3, 0, 4, 2};
        //when
        final var actualIndex = solution(input, 2);
        //then
        final var actual = stream(input).limit(actualIndex).collect(toList());
        final var expected = asList(0, 0, 1, 3, 4);
        assertEquals(expected, actual);
    }

    /**
     * WHEN
     * numbers = [], val = 0
     * THEN
     * returns = 0, nums = []
     */
    @Test
    public void example3() {
        //given
        final var input = new Integer[]{};
        //when
        final var actualIndex = solution(input, 0);
        //then
        assertEquals(0, actualIndex);
    }

    /**
     * WHEN
     * numbers = [2], val = 3
     * THEN
     * returns = 1, nums = [2]
     */
    @Test
    public void example4() {
        //given
        final var input = new Integer[]{2};
        //when
        final var actualIndex = solution(input, 3);
        //then
        final var actual = stream(input).limit(actualIndex).collect(toList());
        final var expected = List.of(2);
        assertEquals(expected, actual);
    }

    /**
     * WHEN
     * numbers = [3,3], val = 5
     * THEN
     * returns = 2, nums = [3,3]
     */
    @Test
    public void example5() {
        //given
        final var input = new Integer[]{3, 3};
        //when
        final var actualIndex = solution(input, 5);
        //then
        final var actual = stream(input).limit(actualIndex).collect(toList());
        final var expected = List.of(3, 3);
        assertEquals(expected, actual);
    }

    /**
     * WHEN
     * numbers = [4,5], val = 4
     * THEN
     * returns = 2, nums = [5]
     */
    @Test
    public void example6() {
        //given
        final var input = new Integer[]{4, 5};
        //when
        final var actualIndex = solution(input, 4);
        //then
        final var actual = stream(input).limit(actualIndex).collect(toList());
        final var expected = List.of(5);
        assertEquals(expected, actual);
    }

    public int solution(final Integer[] nums, final Integer val) {
        if (nums.length == 0) {
            return 0;
        }
        sort(nums);

        var index = 0;
        while (index < nums.length && !Objects.equals(nums[index], val)) {
            index++;
        }

        var index2 = nums.length - 1;
        while (index2 > 0 && !Objects.equals(nums[index2], val)) {
            index2--;
        }
        index2++;

        for (int i = index, j = index2; i < nums.length && j < nums.length; i++, j++) {
            nums[i] = nums[j];
        }

        var counter = 0;
        while (counter < nums.length && !Objects.equals(nums[counter], val)) {
            counter++;
        }
        return counter;
    }
}