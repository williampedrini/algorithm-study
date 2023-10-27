package com.custodio.study.neetcode.slidingwindow;

import org.junit.Assert;
import org.junit.Test;

/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">Neet Code</a>
 */
public class BestTimeToBuyAndSellStock {

    @Test
    public void example1() {
        //given
        final var input = new int[]{7, 1, 5, 3, 6, 4};
        //when
        final var actual = maxProfit(input);
        //then
        final var expected = 5;
        Assert.assertEquals(expected, actual);
    }

    public int maxProfit(int[] prices) {
        var leftIndex = 0;
        var rightIndex = 1;
        var maximumProfit = 0;
        while (leftIndex < prices.length && rightIndex < prices.length) {
            if (leftIndex >= rightIndex) {
                rightIndex++;
                continue;
            }
            final var leftPrice = prices[leftIndex];
            final var rightPrice = prices[rightIndex];
            if (leftPrice < rightPrice) {
                final var profit = rightPrice - leftPrice;
                maximumProfit = Math.max(maximumProfit, profit);
                rightIndex++;
                continue;
            }
            if (leftPrice >= rightPrice) {
                leftIndex++;
                continue;
            }
            rightIndex++;
        }
        return maximumProfit;
    }
}
