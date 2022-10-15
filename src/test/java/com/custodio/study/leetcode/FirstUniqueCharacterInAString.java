package com.custodio.study.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/132-pattern/">Leet Code</a>
 */
public class FirstUniqueCharacterInAString {

    @Test
    public void example1() {
        //given
        final var word = "leetcode";
        //when
        final var actual = solution(word);
        //then
        Assert.assertEquals(0, actual);
    }

    public int solution(final String word) {
        final var letters = word.toCharArray();
        final var result = new HashMap<Character, Integer>();
        for (final char letter : letters) {
            final var occurrence = result.getOrDefault(letter, 0);
            result.put(letter, occurrence + 1);
        }
        for (var index = 0; index < letters.length; index++) {
            final var letter = letters[index];
            final var occurrence = result.get(letter);
            if (occurrence == 1) {
                return index;
            }
        }
        return -1;
    }
}
