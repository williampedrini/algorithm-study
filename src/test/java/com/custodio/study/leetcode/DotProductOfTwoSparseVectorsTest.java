package com.custodio.study.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/dot-product-of-two-sparse-vectors/">Leet Code</a>
 */
public class DotProductOfTwoSparseVectorsTest {

    @Test
    public void example1() {
        //given
        final var vector1 = new SparseVector(new int[]{1, 0, 0, 2, 3});
        final var vector2 = new SparseVector(new int[]{0, 3, 0, 4, 0});
        //when
        final var actual  = vector1.dotProduct(vector2);
        //then
        final var expected = 8;
        assertEquals(expected, actual);
    }

    public static class SparseVector {
        private final int[] nums;

        SparseVector(final int[] nums) {
            this.nums = nums;
        }

        public int dotProduct(final SparseVector vec) {
            var sum = 0;
            for (var index = 0; index < vec.nums.length; index++) {
                final var number = nums[index];
                final var otherNumber = vec.nums[index];
                sum = sum + (number * otherNumber);
            }
            return sum;
        }
    }
}
