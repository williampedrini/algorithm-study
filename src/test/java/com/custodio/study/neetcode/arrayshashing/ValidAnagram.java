package com.custodio.study.neetcode.arrayshashing;

/**
 * @see <a href="https://leetcode.com/problems/valid-anagram/">Neet Code</a>
 */
public class ValidAnagram {

    public boolean solution(final String source, final String target) {
        final var sourceKey = buildKeyFromWord(source);
        final var targetKey = buildKeyFromWord(target);
        return sourceKey.equals(targetKey);
    }

    private String buildKeyFromWord(final String word) {
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
