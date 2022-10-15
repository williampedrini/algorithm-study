package com.custodio.study.leetcode;

import org.jetbrains.annotations.Nullable;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @see <a href="https://leetcode.com/problems/path-sum/">Leet Code</a>
 */
public class PathSum {

    /**
     * WHEN
     * root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
     * THEN
     * returns true
     */
    @Test
    public void example1() {
        //given
        final var root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)
                        ),
                        null
                ), new TreeNode(8,
                new TreeNode(13),
                new TreeNode(4, null, new TreeNode(1))
        ));
        //when
        hasPathSum(root, 10);
        //then
    }

    public boolean hasPathSum(final TreeNode root, final int targetSum) {
        final var result = new ArrayList<Integer>();
        value(result, root, 0);
        return result.contains(targetSum);
    }

    private void value(final Collection<Integer> values, final TreeNode root, int sum) {
        if(root == null) {
            return;
        }
        sum += root.val;
        if (root.left == null && root.right == null) {
            values.add(sum);
            return;
        }
        if(root.right != null) {
            value(values, root.right, sum);
        }
        if(root.left != null) {
            value(values, root.left, sum);
        }
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
