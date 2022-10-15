package com.custodio.study.leetcode;

import org.junit.Test;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/climbing-stairs/">Leet Code</a>
 */
public class BestTimeToBuyAndSellStock {

    @Test
    public void example1() {
        //given
        final var prices = new int[]{7, 1, 5, 3, 6, 4};
        //when
        final var actual = solution2(prices);
        //then
        final var expected = 5;
        assertEquals(expected, actual);
    }

    public int solution(final int[] prices) {
        var result = MIN_VALUE;
        for (var index = 0; index < prices.length; index++) {
            final var buy = prices[index];
            for (var index2 = index + 1; index2 < prices.length; index2++) {
                final var sell = prices[index2];
                final var profit = sell - buy;
                result = max(profit, result);
            }
        }
        return max(result, 0);
    }

    public int solution2(final int[] prices) {
        var maxProfit = 0;
        var minPrice = MAX_VALUE;
        for (final var currentPrice : prices) {
            minPrice = min(currentPrice, minPrice);
            if (minPrice == currentPrice) {
                continue;
            }
            maxProfit = Math.max(maxProfit, currentPrice - minPrice);
        }
        return maxProfit;
    }
}
