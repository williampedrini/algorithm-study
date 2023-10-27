package com.custodio.study.neetcode.slidingwindow;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * @see <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">Neet Code</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {

    @Test
    public void example1() {
        //given
        final var input = "abcabcbb";
        //when
        final var actual = lengthOfLongestSubstring(input);
        //then
        final var expected = 3;
        Assert.assertEquals(expected, actual);
    }

    public int lengthOfLongestSubstring(final String text) {
        //We need to have a set to save all letters we already used.
        //It will help us to verify it in constant time.
        final var visited = new HashSet<Character>();

        //We need to have two pointers since this will be used to identify the current substring range.
        var leftIndex = 0;
        var rightIndex = 0;
        var longestSubstringSize = 0;
        while (rightIndex < text.length()) {
            final var rightCharacter = text.charAt(rightIndex);
            while (visited.contains(rightCharacter)) {
                final var leftCharacter = text.charAt(leftIndex);
                visited.remove(leftCharacter);
                leftIndex++;
            }
            final var size = rightIndex - leftIndex + 1;
            longestSubstringSize = Math.max(longestSubstringSize, size);
            visited.add(rightCharacter);
            rightIndex++;
        }
        return longestSubstringSize;
    }
}
