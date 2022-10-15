package com.custodio.study.datastructure;

import java.util.Objects;
import java.util.Optional;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static java.util.Optional.ofNullable;

class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    private BinaryTree() {
        this(null);
    }

    private BinaryTree(final Node<T> root) {
        this.root = root;
    }

    /**
     * Creates a builder used to create a binary tree.
     *
     * @param <T> The Type used to define the data inside the tree.
     * @return The builder.
     */
    static <T extends Comparable<T>> BinaryTreeBuilder<T> builder() {
        return new BinaryTreeBuilder<>();
    }

    @Override
    public boolean equals(final Object other) {
        if (other instanceof BinaryTree) {
            final var otherBinaryTree = (BinaryTree) other;
            return Objects.equals(root, otherBinaryTree.root);
        }
        return false;
    }

    @Override
    public String toString() {
        return ofNullable(root)
                .map(Objects::toString)
                .orElse("");
    }

    /**
     * Adds a certain value to the tree.
     *
     * @param value The value to be added to the tree.
     */
    private void add(final T value) {
        requireNonNull(value, "The value is mandatory.");
        if (root == null) {
            root = new Node<>(value);
        } else {
            add(value, root);
        }
    }

    private void add(final T value, final Node<T> node) {
        if (node.value.compareTo(value) >= 0) {
            node.getLeft().ifPresentOrElse(
                    left -> add(value, left),
                    () -> node.setLeft(new Node<>(value))
            );
        } else {
            node.getRight().ifPresentOrElse(
                    right -> add(value, right),
                    () -> node.setRight(new Node<>(value))
            );
        }
    }

    static class BinaryTreeBuilder<T extends Comparable<T>> {
        private final BinaryTree<T> tree;

        private BinaryTreeBuilder() {
            this.tree = new BinaryTree<>();
        }

        BinaryTreeBuilder<T> add(final T value) {
            requireNonNull(value, "The value is mandatory.");
            tree.add(value);
            return this;
        }

        BinaryTree<T> build() {
            return tree;
        }
    }

    private static class Node<T> {
        private final T value;
        private Node<T> left;
        private Node<T> right;

        private Node(final T value) {
            this(value, null, null);
        }

        private Node(final T value, final Node<T> left, final Node<T> right) {
            this.value = requireNonNull(value, "Value is mandatory.");
            this.left = left;
            this.right = right;
        }

        private T getValue() {
            return value;
        }

        private Optional<Node<T>> getLeft() {
            return ofNullable(left);
        }

        private void setLeft(final Node<T> left) {
            this.left = left;
        }

        private Optional<Node<T>> getRight() {
            return ofNullable(right);
        }

        private void setRight(final Node<T> right) {
            this.right = right;
        }

        @Override
        public boolean equals(final Object other) {
            if (other instanceof Node) {
                final var otherNode = (Node) other;
                return equals(this, otherNode);
            }
            return false;
        }

        @Override
        public String toString() {
            final var toStringBuilder = new StringBuilder();
            toString(toStringBuilder, this);
            return toStringBuilder.toString();
        }

        private void toString(final StringBuilder toStringBuilder, final Node<T> node) {
            if (node == null) {
                return;
            }

            final var leftValue = node.getLeft()
                    .map(Node::getValue)
                    .map(Objects::toString)
                    .orElse("");

            final var rightValue = node.getRight()
                    .map(Node::getValue)
                    .map(Objects::toString)
                    .orElse("");

            final var value = format("Node{value=%s,left=%s,right=%s}", node.value, leftValue, rightValue);
            toStringBuilder.append(value);

            toString(toStringBuilder, node.left);
            toString(toStringBuilder, node.right);
        }

        private boolean equals(final Node<T> node1, final Node<T> node2) {
            if (node1 == null && node2 == null) {
                return true;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (!node1.value.equals(node2.value)) {
                return false;
            }
            return equals(node1.left, node2.left) && equals(node1.right, node2.right);
        }
    }
}
