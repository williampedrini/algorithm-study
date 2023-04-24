package com.custodio.study.neetcode.slidingwindow;

import org.junit.Test;

import static java.lang.Math.max;
import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">Neet Code</a>
 */
public class BestTimeToBuyAndSellStock {

    @Test
    public void example1() {
        //given
        final var input = new int[]{7, 1, 5, 3, 6, 4};
        //when
        final var actual = solution(input);
        //then
        final var expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        //given
        final var input = new int[]{7, 6, 4, 3, 1};
        //when
        final var actual = solution(input);
        //then
        final var expected = 0;
        assertEquals(expected, actual);
    }

    public int solution(final int[] prices) {
        var buyDayIndex = 0;
        var sellDayIndex = buyDayIndex + 1;
        var maxProfit = 0;
        while (buyDayIndex < prices.length && sellDayIndex < prices.length) {
            final var buyDayValue = prices[buyDayIndex];
            final var sellDayValue = prices[sellDayIndex];
            final var profit = sellDayValue - buyDayValue;
            maxProfit = max(maxProfit, profit);
            if (buyDayValue <= sellDayValue) {
                sellDayIndex++;
            }
            if (buyDayValue > sellDayValue) {
                buyDayIndex++;
                sellDayIndex = buyDayIndex + 1;
            }
        }
        return maxProfit;
    }
}
