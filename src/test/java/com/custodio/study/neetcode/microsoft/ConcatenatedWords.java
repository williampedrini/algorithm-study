package com.custodio.study.neetcode.microsoft;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/concatenated-words">Neet Code</a>
 */
public class ConcatenatedWords
{
    @Test
    public void example1()
    {
        //given
        final var input = new String[]{
                "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        //when
        final var actual = findAllConcatenatedWordsInADict(input);
        //then
        final var expected = List.of("catsdogcats","dogcatsdog","ratcatdogcat");
        Assert.assertEquals(expected, actual);

    }

    public List<String> findAllConcatenatedWordsInADict(final String[] words)
    {
        //Creates a word set to identify the existence of words effectively.
        final var set = new HashSet<>(Arrays.asList(words));

        final var result = new ArrayList<String>();

        for (var word : words)
        {
            var size = word.length();

            //We need to see if all the letter of the word exists as words in the set.
            for (int begin = 0, end = 0; end < word.length(); end++)
            {
                final var substring = word.substring(begin, end + 1);

                //We will decrease the amount of letters from the word total size to identify if the entire word was used.
                if (set.contains(substring) && !substring.equals(word))
                {
                    begin = end + 1;
                    size -= substring.length();
                }
            }
            if (size == 0)
            {
                result.add(word);
            }
        }
        return result;
    }
}
