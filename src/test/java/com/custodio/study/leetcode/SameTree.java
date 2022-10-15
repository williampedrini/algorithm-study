package com.custodio.study.leetcode;

import org.jetbrains.annotations.Nullable;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @see <a href="https://leetcode.com/problems/same-tree/">Leet Code</a>
 */
public class SameTree {

    /**
     * WHEN
     * source = [1,2,3], target = [1,2,3]
     * THEN
     * returns true
     */
    @Test
    public void example1() {
        //given
        final var source = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        final var target = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        //when
        final var actual = isSameTree(source, target);
        //then
        assertTrue(actual);
    }

    /**
     * WHEN
     * source = [1,2], target = [1,null,2]
     * THEN
     * returns false
     */
    @Test
    public void example2() {
        //given
        final var source = new TreeNode(1, new TreeNode(2), null);
        final var target = new TreeNode(1, null, new TreeNode(2));
        //when
        final var actual = isSameTree(source, target);
        //then
        assertFalse(actual);
    }

    public boolean isSameTree(final TreeNode source, final TreeNode target) {
        return solution(source, target);
    }

    public boolean solution(final TreeNode source, final TreeNode target) {
        if (source == null && target == null) {
            return true;
        }
        final var hasBothNodesNotNull = source != null && target != null;
        if (hasBothNodesNotNull && source.val == target.val) {
            return solution(source.left, target.left) && solution(source.right, target.right);
        }
        return false;
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
