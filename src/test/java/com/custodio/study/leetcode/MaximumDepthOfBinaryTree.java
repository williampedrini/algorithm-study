package com.custodio.study.leetcode;

import org.jetbrains.annotations.Nullable;
import org.junit.Test;

import static java.lang.Math.max;
import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">Leet Code</a>
 */
public class MaximumDepthOfBinaryTree {

    /**
     * WHEN
     * root = [3,9,20,null,null,15,7]
     * THEN
     * returns = 3
     */
    @Test
    public void example1() {
        //given
        final var root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        //when
        final var actual = solution(root);
        //then
        final var expected = 3;
        assertEquals(expected, actual);
    }

    public int solution(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        final var leftValue = solution(root.left);
        final var rightValue = solution(root.right);
        return max(leftValue, rightValue) + 1;
    }

    private static class TreeNode {
        private final int val;
        private final TreeNode left;
        private final TreeNode right;

        TreeNode() {
            this(0, null, null);
        }

        TreeNode(final int val) {
            this(val, null, null);
        }

        TreeNode(final int val, @Nullable final TreeNode left, @Nullable final TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
