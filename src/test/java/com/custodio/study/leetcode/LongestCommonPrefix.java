package com.custodio.study.leetcode;

import org.junit.Test;

import static java.util.Arrays.sort;
import static java.util.Comparator.comparingInt;
import static org.junit.Assert.assertEquals;

public class LongestCommonPrefix {

    /**
     * WHEN
     * words = ["flower","flow","flight"]
     * THEN
     * returns "fl"
     */
    @Test
    public void example1() {
        //when
        final var actual = solution(new String[]{"flower", "flow", "flight"});
        //then
        final var expected = "fl";
        assertEquals(expected, actual);
    }

    /**
     * WHEN
     * words = ["dog","racecar","car"]
     * THEN
     * returns ""
     */
    @Test
    public void example2() {
        //when
        final var actual = solution(new String[]{"dog", "racecar", "car"});
        //then
        final var expected = "";
        assertEquals(expected, actual);
    }

    public String solution(final String[] words) {
        sort(words, comparingInt(String::length));
        var prefix = words[0];
        for (var i = 1; i < words.length; i++) {
            final var word = words[i];
            while (word.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
