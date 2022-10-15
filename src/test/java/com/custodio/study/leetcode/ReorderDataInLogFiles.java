package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeSet;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertArrayEquals;

/**
 * @see <a href="https://leetcode.com/problems/reorder-data-in-log-files/">Leet Code</a>
 */
public class ReorderDataInLogFiles {

    @Test
    public void example1() {
        //given
        final var logs = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        //when
        final var actual = solution(logs);
        //then
        final var expected = new String[]{"let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6"};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void example2() {
        //given
        final var logs = new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
        //when
        final var actual = solution(logs);
        //then
        final var expected = new String[]{"g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7"};
        assertArrayEquals(expected, actual);
    }

    public String[] solution(final String[] logs) {
        final var letterLogs = new TreeSet<Log>();
        final var digitLogs = new ArrayList<Log>();

        for (var rawLog : logs) {
            final var rawContent = rawLog.split(" ");
            final var identifier = rawContent[0];
            final var content = rawLog.substring(identifier.length());
            final var log = new Log(identifier, content);
            final var firstReadableContent = rawContent[1].charAt(0);
            if (isLetter(firstReadableContent)) {
                letterLogs.add(log);
            }
            if (isDigit(firstReadableContent)) {
                digitLogs.add(log);
            }
        }

        final var rawLetterLogs = letterLogs
                .stream()
                .map(Log::toString)
                .collect(toList());

        final var rawDigitLogs = digitLogs
                .stream()
                .map(Log::toString)
                .collect(toList());

        final var result = new ArrayList<String>();
        result.addAll(rawLetterLogs);
        result.addAll(rawDigitLogs);
        return result.toArray(new String[]{});
    }

    private static class Log implements Comparable<Log> {
        private final String id;
        private final String content;

        private Log(final String id, final String content) {
            this.id = requireNonNull(id);
            this.content = requireNonNull(content);
        }

        @Override
        public int compareTo(final ReorderDataInLogFiles.Log other) {
            if (Objects.equals(this.content, other.content)) {
                return this.id.compareTo(other.id);
            }
            return this.content.compareTo(other.content);
        }

        @Override
        public String toString() {
            return format("%s%s", id, content);
        }
    }
}
