package com.custodio.study.leetcode;

import org.jetbrains.annotations.Nullable;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @see <a href="https://leetcode.com/problems/same-tree/">Leet Code</a>
 */
public class SymmetricTree {

    /**
     * WHEN
     * root = [1,2,2,3,4,4,3]
     * THEN
     * returns true
     */
    @Test
    public void example1() {
        //given
        //when
        //then
    }

    public boolean isSymmetric(final TreeNode root) {
        if (root.left != null && root.right != null) {
            final var leftSubTree = new ArrayList<Integer>();
            solution(leftSubTree, root.left);

            final var rightSubTree = new ArrayList<Integer>();
            solution2(rightSubTree, root.right);
            return leftSubTree.equals(rightSubTree);
        }
        return root.left == null && root.right == null;
    }

    private void solution(final Collection<Integer> subTree, final TreeNode node) {
        if (node == null) {
            subTree.add(null);
            return;
        }
        subTree.add(node.val);
        solution(subTree, node.left);
        solution(subTree, node.right);
    }

    private void solution2(final Collection<Integer> subTree, final TreeNode node) {
        if (node == null) {
            subTree.add(null);
            return;
        }
        subTree.add(node.val);
        solution2(subTree, node.right);
        solution2(subTree, node.left);
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
