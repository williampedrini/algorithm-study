package com.custodio.study.neetcode.arrayshashing;

import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/encode-and-decode-strings/">Neet Code</a>
 */
public class EncodeAndDecodeStrings {
    private static final Character TOKEN = '#';

    @Test
    public void example1() {
        //given
        final var rawTexts = asList("Hello", "World");
        //when
        final var encode = encode(rawTexts);
        final var decoded = decode(encode);
        //then
        assertEquals(rawTexts, decoded);
    }

    public String encode(final Collection<String> rawTexts) {
        return null;
    }

    public List<String> decode(final String encodedText) {
        return null;
    }
}
