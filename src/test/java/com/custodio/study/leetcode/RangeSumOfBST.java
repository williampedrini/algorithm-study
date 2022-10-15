package com.custodio.study.leetcode;

import org.jetbrains.annotations.Nullable;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/palindrome-number/">Leet Code</a>
 */
public class RangeSumOfBST {

    @Test
    public void example1() {
        //given
        final var tree = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)), new TreeNode(15, null, new TreeNode(18)));
        final var low = 7;
        final var high = 15;
        //when
        final var actual = solution(tree, low, high);
        //then
        final var expected = 32;
        assertEquals(expected, actual);
    }

    public int solution(final TreeNode root, final int low, final int high) {
        final var nodes = new ArrayList<TreeNode>();
        solution(nodes, root, low, high);
        return nodes
                .stream()
                .mapToInt(node -> node.val)
                .sum();
    }

    private void solution(final Collection<TreeNode> nodes, final TreeNode node, int low, int high) {
        if (node == null) {
            return;
        }
        if (node.val >= low && node.val <= high) {
            nodes.add(node);
        }
        solution(nodes, node.left, low, high);
        solution(nodes, node.right, low, high);
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
