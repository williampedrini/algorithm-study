package com.custodio.study.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.List.of;
import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.toList;

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-vertical-order-traversal/">Leet Code</a>
 */
public class BinaryTreeVerticalOrderTraversal {

    @Test
    public void example1() {
        //given
        final var root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        //when
        final var actual = verticalOrder(root);
        //then
        final var expected = new ArrayList<List<Integer>>();
        expected.add(of(9));
        expected.add(asList(3, 15));
        expected.add(of(20));
        expected.add(of(7));
        Assert.assertEquals(expected, actual);
    }

    public List<List<Integer>> verticalOrder(final TreeNode root) {
        final var nodesByLine = new HashMap<Integer, Map<Integer, Collection<Integer>>>();
        solution(root, nodesByLine, 0, 0);
        final var nodes = new ArrayList<List<Integer>>();
        for (final var entry : nodesByLine
                .entrySet()
                .stream()
                .sorted(comparingByKey())
                .map(Map.Entry::getValue)
                .collect(toList())) {
            final var innerNodes = new ArrayList<Integer>();
            for(final var innerEntry: entry.entrySet()) {
                innerNodes.addAll(innerEntry.getValue());
            }
            nodes.add(innerNodes);
        }
        return nodes;
    }

    public void solution(final TreeNode node, final Map<Integer, Map<Integer, Collection<Integer>>> matrix, final int column, final int row) {
        if (node == null) {
            return;
        }
        final var vertical = matrix.getOrDefault(column, new HashMap<>());
        final var horizontal = vertical.getOrDefault(row, new ArrayList<>());
        horizontal.add(node.value);
        vertical.put(row, horizontal.stream().sorted().collect(toList()));
        matrix.put(column, vertical);

        solution(node.left, matrix, column - 1, row + 1);
        solution(node.right, matrix, column + 1, row + 1);
    }

    public class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {
        }

        public TreeNode(final int value) {
            this.value = value;
        }

        TreeNode(final int value, final TreeNode left, final TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }
    }
}