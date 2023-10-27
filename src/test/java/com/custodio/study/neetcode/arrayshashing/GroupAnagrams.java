package com.custodio.study.neetcode.arrayshashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/group-anagrams/">Neet Code</a>
 */
public class GroupAnagrams
{

    public List<List<String>> groupAnagrams(final String[] words)
    {
        //It will group all the anagrams by key. Where the key is build based on the amount of letters in the word.
        final var groups = new HashMap<String, List<String>>();

        //Iterate over each word and build the key based on the word letters amount.
        for (final var word : words)
        {
            final var key = buildKeyFrom(word);
            final var anagrams = groups.getOrDefault(key, new ArrayList<>());
            anagrams.add(word);
            groups.put(key, anagrams);
        }
        return new ArrayList<>(groups.values());
    }

    private String buildKeyFrom(final String word)
    {
        //We will calculate the repetition of letters and persist it on an array. Where each position is the letter.
        final var letters = new int[26];

        for (var index = 0; index < word.length(); index++)
        {
            final var letter = word.charAt(index);
            //In java if we have a binary operation between int and char it will convert it to a char.
            final var letterIndex = letter - 'a';
            letters[letterIndex]++;
        }
        //Create the key based on the amount of letters found.
        final var keyBuilder = new StringBuilder();
        for (var index = 0; index < letters.length; index++)
        {
            final var quantity = letters[index];
            if (quantity > 0)
            {
                //Get the current letter by summing up the current index with 'a' which represents 0;
                final var letter = 'a' + index;
                keyBuilder.append(quantity).append(letter);
            }
        }
        return keyBuilder.toString();
    }
}
