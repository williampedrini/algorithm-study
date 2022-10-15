package com.custodio.study.leetcode;

import org.jetbrains.annotations.Nullable;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;

import static java.lang.Integer.MAX_VALUE;
import static java.util.Comparator.naturalOrder;
import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/">Leet Code</a>
 */
public class MinimumDepthOfBinaryTree {

    @Test
    public void example1() {
        //given
        final var tree = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        //when
        final var actual = minDepth(tree);
        //then
        final var expected = 2;
        assertEquals(expected, actual);
    }

    public int minDepth(final TreeNode root) {
        if(root == null) {
            return 0;
        }
        final var levels = new HashSet<Integer>();
        solution(levels, root, 1);
        return levels
                .stream()
                .min(naturalOrder())
                .orElse(0);
    }

    private void solution(final Collection<Integer> levels, final TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            levels.add(sum);
            return;
        }
        sum++;
        if (root.left != null) {
            solution(levels, root.left, sum);
        }
        if (root.right != null) {
            solution(levels, root.right, sum);
        }
    }

    private int solution2(final TreeNode root) {
        if(root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min = MAX_VALUE;
        if(root.left != null) {
            min = Math.min(solution2(root.left), min);
        }
        if(root.right != null) {
            min = Math.min(solution2(root.right), min);
        }
        return min + 1;
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
