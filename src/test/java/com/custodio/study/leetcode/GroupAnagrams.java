package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/group-anagrams/">Leet Code</a>
 */
public class GroupAnagrams {

    @Test
    public void example1() {
        //given
        final var words = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        //when
        final var actual = groupAnagrams(words);
        //then
        final var expected = asList(
                List.of("bat"),
                asList("nat", "tan"),
                asList("ate", "eat", "tea")
        );
        assertEquals(expected, actual);
    }

    public List<List<String>> groupAnagrams(final String[] words) {
        final var groups = new HashMap<String, List<String>>();

        final var convertedWords = stream(words)
                .map(Word::new)
                .collect(toList());

        for (final var word : convertedWords) {
            final var anagrams = groups.getOrDefault(word.getKey(), new ArrayList<>());
            anagrams.add(word.getValue());
            groups.put(word.getKey(), anagrams);
        }

        return new ArrayList<>(groups.values());
    }

    public static class Word {
        private final String key;
        private final String value;

        public Word(final String word) {
            key = buildKey(word);
            value = word;
        }

        private static String buildKey(final String word) {
            final int[] letters = new int[26];
            for (final var letter : word.toCharArray()) {
                letters[letter - 'a']++;
            }
            final var toStringBuilder = new StringBuilder();
            for (var index = 0; index < letters.length; index++) {
                final var quantity = letters[index];
                if (quantity > 0) {
                    final var letter = (char) (97 + index);
                    toStringBuilder.append(letter);
                    toStringBuilder.append(quantity);
                }
            }
            return toStringBuilder.toString();
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }
}
