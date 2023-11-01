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

        final var palindromes = new PriorityQueue<String>((word1, word2) -> compare(word2.length(), word1.length()));

        for (var index = 0; index < word.length(); index++)
        {
            //When the size of the string id odd.
            for (int leftIndex = index, rightIndex = index; leftIndex > -1 && rightIndex < word.length(); leftIndex--, rightIndex++)
            {
                final var left = word.charAt(leftIndex);
                final var right = word.charAt(rightIndex);
                if(left == right) {
                    final var palindrome = word.substring(leftIndex, rightIndex + 1);
                    palindromes.add(palindrome);
                    continue;
                }
                break;
            }

            //When the size of the string is even.
            for (int leftIndex = index, rightIndex = index + 1; leftIndex > -1 && rightIndex < word.length(); leftIndex--, rightIndex++)
            {
                final var left = word.charAt(leftIndex);
                final var right = word.charAt(rightIndex);
                if(left == right) {
                    final var palindrome = word.substring(leftIndex, rightIndex + 1);
                    palindromes.add(palindrome);
                    continue;
                }
                break;
            }
        }
        return palindromes.isEmpty() ? "" : palindromes.poll();
    }
}
