package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.sort;
import static java.util.Comparator.comparingInt;
import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">Leet Code</a>
 */
public class MaximumPopulationYear {
    private final static int BIRTH_INDEX = 0;
    private final static int DEATH_INDEX = 1;

    @Test
    public void example1() {
        //given
        final var logs = new int[][]{{1950, 1961}, {1960, 1971}, {1970, 1981}};
        //when
        final var actual = solution(logs);
        //then
        final var expected = 1960;
        assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        //given
        final var logs = new int[][]{{2000, 2001}};
        //when
        final var actual = solution(logs);
        //then
        final var expected = 2000;
        assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        //given
        final var logs = new int[][]{{2033, 2034}, {2039, 2047}, {1998, 2042}, {2047, 2048}, {2025, 2029}, {2005, 2044}, {1990, 1992}, {1952, 1956}, {1984, 2014}};
        //when
        final var actual = solution(logs);
        //then
        final var expected = 2005;
        assertEquals(expected, actual);
    }

    @Test
    public void example4() {
        //given
        final var logs = new int[][]{{1987, 2047}, {1952, 2006}, {2021, 2042}, {2047, 2049}, {2036, 2040}, {1994, 2009}};
        //when
        final var actual = solution(logs);
        //then
        final var expected = 1994;
        assertEquals(expected, actual);
    }

    public int solution(final int[][] logs) {
        sort(logs, comparingInt(log -> log[BIRTH_INDEX]));

        if (logs.length == 1) {
            return logs[0][BIRTH_INDEX];
        }

        final var yearByQuantity = new HashMap<Integer, Integer>();

        for (var index = 0; index < logs.length; index++) {
            int[] log = logs[index];
            final var personDeathYear = log[DEATH_INDEX];

            for (var index2 = index + 1; index2 < logs.length; index2++) {
                int[] nextLog = logs[index2];
                final var nextPersonBirthYear = nextLog[BIRTH_INDEX];
                final var nextPersonDeathYear = nextLog[DEATH_INDEX];

                if (nextPersonBirthYear <= personDeathYear - 1 && nextPersonDeathYear - nextPersonBirthYear > 0) {
                    final var quantity = yearByQuantity.getOrDefault(nextPersonBirthYear, 0);
                    yearByQuantity.put(nextPersonBirthYear, quantity + 1);
                }
            }
        }

        if (yearByQuantity.isEmpty()) {
            return logs[0][BIRTH_INDEX];
        }

        var maxQuantity = yearByQuantity
                .values()
                .stream()
                .mapToInt(quantity -> quantity)
                .max()
                .orElse(0);

        return yearByQuantity
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxQuantity)
                .mapToInt(Map.Entry::getKey)
                .min()
                .orElse(0);
    }
}
