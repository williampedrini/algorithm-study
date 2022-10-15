package com.custodio.study.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @see <a href="https://leetcode.com/problems/implement-strstr/">Leet Code</a>
 */
public class ImplementStrStr {

    @Test
    public void example1() {
        //when
        final var actual = solution("hello", "ll");
        //then
        final var expected = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        //when
        final var actual = solution("aaaaa", "bba");
        //then
        final var expected = -1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        //when
        final var actual = solution("", "");
        //then
        final var expected = 0;
        Assert.assertEquals(expected, actual);
    }

    private int solution(final String haystack, final String needle) {
        return haystack.indexOf(needle);
    }
}
