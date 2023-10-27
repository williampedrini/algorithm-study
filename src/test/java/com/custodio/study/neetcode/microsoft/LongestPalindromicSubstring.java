package com.custodio.study.neetcode.microsoft;

import org.junit.Test;

import java.util.PriorityQueue;

import static java.lang.Integer.compare;
import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/longest-palindromic-substring">Neet Code</a>
 */
public class LongestPalindromicSubstring
{
    @Test
    public void example1()
    {
        //given
        final String input = "aacabdkacaa";
        //when
        final String actual = longestPalindrome(input);
        //then
        final String expected = "aca";
        assertEquals(expected, actual);
    }

    public String longestPalindrome(final String word)
    {
        //I will use an expanding window to create a substring based on the word.
        //The window will require two pointer to work, left and a right.
        //The left one will be used to expand to the left.
        //The right one will be used to expand to the right.
        //It will be expanded until the left pointer reaches the beginning of the word
        //Ot the right one reaches the end of the array.
        //To calculate the longest, I will use a priority queue, which will use the size of the string as a comparator.

        final var words = new PriorityQueue<String>((string1, string2) -> compare(string2.length(), string1.length()));

        for (var index = 0; index < word.length(); index++)
        {
            //There is two cases. When the word length is even or odd.

            for (int left = index, right = index; left > -1 && right < word.length(); left--, right++)
            {
                final var leftLetter = word.charAt(left);
                final var rightLetter = word.charAt(right);
                if (leftLetter == rightLetter)
                {
                    final var substring = word.substring(left, right + 1);
                    words.add(substring);
                    continue;
                }
                break;
            }

            for (int left = index, right = index + 1; left > -1 && right < word.length(); left--, right++)
            {
                final var leftLetter = word.charAt(left);
                final var rightLetter = word.charAt(right);
                if (leftLetter == rightLetter)
                {
                    final var substring = word.substring(left, right + 1);
                    words.add(substring);
                    continue;
                }
                break;
            }
        }
        return words.poll();
    }
}
