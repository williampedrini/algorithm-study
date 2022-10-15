package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.Objects;
import java.util.Optional;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static java.util.Optional.empty;
import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/reformat-date/">Leet Code</a>
 */
public class ReformatDate {

    @Test
    public void example1() {
        //given
        final var input = "20th Oct 2052";
        //when
        final var actual = solution(input);
        //then
        final var expected = "2052-10-20";
        assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        //given
        final var input = "6th Oct 2052";
        //when
        final var actual = solution(input);
        //then
        final var expected = "2052-10-06";
        assertEquals(expected, actual);
    }

    public String solution(final String date) {
        return new Date(date).toString();
    }

    private enum Month {
        JANUARY("Jan", "01", 31),
        FEBRUARY("Feb", "02", 28),
        MARCH("Mar", "03", 31),
        APRIL("Apr", "04", 30),
        MAY("May", "05", 31),
        JUNE("Jun", "06", 30),
        JULY("Jul", "07", 31),
        AUGUST("Aug", "08", 31),
        SEPTEMBER("Sep", "09", 30),
        OCTOBER("Oct", "10", 31),
        NOVEMBER("Nov", "11", 30),
        DECEMBER("Dec", "12", 31);

        private final String value;
        private final String valueAsDigit;
        private final int maximumDay;

        Month(final String value, final String valueAsDigit, final int maximumDay) {
            this.value = requireNonNull(value, "The value is mandatory.");
            this.valueAsDigit = requireNonNull(valueAsDigit, "The digit value is mandatory.");
            this.maximumDay = maximumDay;
        }

        private static Optional<Month> getByValue(final String value) {
            for (var month : Month.values()) {
                if (Objects.equals(month.value, value)) {
                    return Optional.of(month);
                }
            }
            return empty();
        }

        private String getValue() {
            return value;
        }

        private String getValueAsDigit() {
            return valueAsDigit;
        }

        private int getMaximumDay() {
            return maximumDay;
        }
    }

    private static class Date {
        private final String day;
        private final Month month;
        private final String year;

        private Date(final String date) {
            final var dateParts = date.split(" ");
            if (dateParts.length == 3) {
                var numberCounter = 0;
                for (var dayPart : dateParts[0].toCharArray()) {
                    if (Character.isDigit(dayPart)) {
                        numberCounter++;
                    } else {
                        break;
                    }
                }
                if(numberCounter > 1) {
                    day = dateParts[0].substring(0, numberCounter);
                } else {
                    day = "0" + dateParts[0].substring(0, numberCounter);
                }
                month = Month.getByValue(dateParts[1]).orElse(null);
                year = dateParts[2];
            } else {
                day = "";
                month = null;
                year = "";
            }
        }

        @Override
        public String toString() {
            if (year.length() == 4 && parseInt(day) <= month.getMaximumDay() && parseInt(day) >= 1) {
                return format("%s-%s-%s", year, month.getValueAsDigit(), day);
            }
            return "";
        }
    }
}
