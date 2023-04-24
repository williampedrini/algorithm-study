package com.custodio.study.neetcode.arrayshashing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @see <a href="https://leetcode.com/problems/group-anagrams/">Neet Code</a>
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(final String[] words) {
        final var groups = new HashMap<String, List<String>>();
        for (final var word : words) {
            final var key = getKeyFromWord(word);
            final var anagrams = groups.getOrDefault(key, new ArrayList<>());
            anagrams.add(word);
            groups.put(key, anagrams);
        }
        return new ArrayList<>(groups.values());
    }

    private String getKeyFromWord(final String word) {
        final var letterQuantity = new int[26];

        for (var index = 0; index < word.length(); index++) {
            final var letter = word.charAt(index);
            final var letterIndex = letter - 'a';
            letterQuantity[letterIndex]++;
        }

        final var keyBuilder = new StringBuilder();
        for (var index = 0; index < letterQuantity.length; index++) {
            final var quantity = letterQuantity[index];
            if (quantity > 0) {
                final var letter = (char) ('a' + index);
                keyBuilder.append(quantity);
                keyBuilder.append(letter);
            }
        }
        return keyBuilder.toString();
    }
}
