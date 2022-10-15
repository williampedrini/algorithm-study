package com.custodio.study.leetcode;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

/**
 * @see <a href="https://leetcode.com/problems/merge-sorted-array/">Leet Code</a>
 */
public class MergeIntervals {

    @Test
    public void example1() {
        //given
        final var input = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        //when
        final var actual = merge(input);
        //then
        final var expected = new int[][]{{1, 6}, {8, 10}, {15, 18}};
        Assert.assertArrayEquals(expected, actual);
    }

    public int[][] merge(final int[][] intervals) {
        final var convertedIntervals = stream(intervals)
                .map(Interval::new)
                .sorted()
                .collect(toList());
        final var verifiedIntervals = new ArrayDeque<Interval>();
        for (final var interval : convertedIntervals) {
            final var previousInterval = verifiedIntervals.peek();
            if (!verifiedIntervals.isEmpty() && interval.begin - previousInterval.end <= 0) {
                verifiedIntervals.pop(); //remove the last one and add a new interval.
                verifiedIntervals.push(new Interval(previousInterval.begin, Math.max(interval.end, previousInterval.end)));
                continue;
            }
            verifiedIntervals.push(interval);
        }
        return verifiedIntervals
                .stream()
                .sorted()
                .map(interval -> new int[]{interval.begin, interval.end})
                .collect(toList())
                .toArray(new int[][]{});
    }

    public static class Interval implements Comparable<Interval> {
        private final static int BEGIN = 0;
        private final static int END = 1;

        private final int begin;
        private final int end;

        public Interval(final int[] interval) {
            this(interval[BEGIN], interval[END]);
        }

        private Interval(final int begin, final int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public int compareTo(@NotNull final MergeIntervals.Interval other) {
            return Integer.compare(begin, other.begin);
        }
    }
}
