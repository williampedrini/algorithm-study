package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/excel-sheet-column-title/">Leet Code</a>
 */
public class ExcelSheetColumnTitle {

    private static final List<String> LETTERS = asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

    @Test
    public void example1() {
        //given
        final var column = 1;
        //when
        final var actual = solution(column);
        //then
        final var expected = "A";
        assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        //given
        final var column = 28;
        //when
        final var actual = solution(column);
        //then
        final var expected = "AB";
        assertEquals(expected, actual);
    }

    public String solution(int column) {
        final var titleBuilder = new StringBuilder();
        for (int index = 0; index < column % LETTERS.size(); index++) {
            final var letter = LETTERS.get(index);
            titleBuilder.append(letter);
        }
        return titleBuilder.toString();
    }
}
