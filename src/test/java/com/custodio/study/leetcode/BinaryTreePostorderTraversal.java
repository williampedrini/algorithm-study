package com.custodio.study.leetcode;

import org.jetbrains.annotations.Nullable;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">Leet Code</a>
 */
public class BinaryTreePostorderTraversal {

    @Test
    public void example1() {
        //given
        final var tree = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        //when
        final var actual = solution(tree);
        //then
        final var expected = asList(3, 2, 1);
        assertEquals(expected, actual);
    }

    public Collection<Integer> solution(final TreeNode root) {
        final var values = new ArrayList<Integer>();
        solution(values, root);
        return values;
    }

    public void solution(final Collection<Integer> values, final TreeNode root) {
        if (root == null) {
            return;
        }
        solution(values, root.left);
        solution(values, root.right);
        values.add(root.val);
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
