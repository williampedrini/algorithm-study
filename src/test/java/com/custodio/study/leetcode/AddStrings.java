package com.custodio.study.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/add-strings/">Leet Code</a>
 */
public class AddStrings {

    @Test
    public void example1() {
        //given
        final var number1 = "9333852702227987";
        final var number2 = "85731737104263";
        //when
        final var actual = solution(number1, number2);
        //then
        final var expected = "9419584439332250";
        assertEquals(expected, actual);
    }

    public String solution(final String number1, final String number2) {
        final var resultBuilder = new StringBuilder();
        final var number1AsArray = number1.toCharArray();
        final var number2AsArray = number2.toCharArray();

        for (int indexNumber1 = number1.length() - 1, indexNumber2 = number2.length() - 1, carry = 0; indexNumber1 >= 0 || indexNumber2 >= 0; indexNumber1--, indexNumber2--) {
            if (indexNumber1 >= 0 && indexNumber2 >= 0) {
                final var number1Digit = number1AsArray[indexNumber1] - '0';
                final var number2Digit = number2AsArray[indexNumber2] - '0';
                final var sum = number1Digit + number2Digit + carry;
                final var mod = sum % 10;
                carry = sum >= 10 ? 1 : 0;
                resultBuilder.append(mod);
            } else if (indexNumber1 >= 0) {
                final var number1Digit = number1AsArray[indexNumber1] - '0';
                final var sum = number1Digit + carry;
                carry = sum >= 10 ? 1 : 0;
                resultBuilder.append(sum);
            } else if (indexNumber2 >= 0) {
                final var number2Digit = number2AsArray[indexNumber2] - '0';
                final var sum = number2Digit + carry;
                carry = sum >= 10 ? 1 : 0;
                resultBuilder.append(sum);
            }
        }
        return resultBuilder
                .reverse()
                .toString();
    }
}
