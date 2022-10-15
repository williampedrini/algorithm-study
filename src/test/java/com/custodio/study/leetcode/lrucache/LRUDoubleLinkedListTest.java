package com.custodio.study.leetcode.lrucache;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static java.lang.Integer.valueOf;
import static java.util.Objects.requireNonNull;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LRUDoubleLinkedListTest {

    @Test
    public void example1() {
        //given
        final var actual = new LRUDoubleLinkedList<Integer>();
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        //when
        final var node = actual.get(3);
        actual.remove(node.get());
        //then
        final var expected = new LRUDoubleLinkedList<Integer>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        //given
        final var actual = new LRUDoubleLinkedList<Integer>();
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        //when
        final var actualNode = actual.getLeastRecentUsed();
        //then
        final var expectedNode = valueOf(1);
        assertTrue(actualNode.isPresent());
        assertEquals(expectedNode, actualNode.get().getValue());
    }

    public static class LRUDoubleLinkedList<T> {
        private final LRUCacheNode<T> leastRecentUsed;
        private final LRUCacheNode<T> mostRecentUsed;

        public LRUDoubleLinkedList() {
            this(new LRUCacheNode<>(), new LRUCacheNode<>());
        }

        private LRUDoubleLinkedList(final LRUCacheNode<T> leastRecentUsed,
                                    final LRUCacheNode<T> mostRecentUsed) {
            this.leastRecentUsed = requireNonNull(leastRecentUsed, "The node is mandatory.");
            this.mostRecentUsed = requireNonNull(mostRecentUsed, "The node is mandatory.");
            this.leastRecentUsed.setNext(mostRecentUsed);
            this.mostRecentUsed.setPrevious(leastRecentUsed);
        }

        public void add(final T value) {
            requireNonNull(value, "The value is mandatory.");
            add(new LRUCacheNode<>(value));
        }

        public void add(final LRUCacheNode<T> node) {
            requireNonNull(node, "The node is mandatory.");
            var previous = mostRecentUsed.getPrevious();
            previous.setNext(node);
            node.setPrevious(previous);
            node.setNext(mostRecentUsed);
            mostRecentUsed.setPrevious(node);
        }

        public boolean isEmpty() {
            return leastRecentUsed.getNext() == mostRecentUsed;
        }

        public Optional<LRUCacheNode<T>> get(final int index) {
            if (isEmpty()) {
                return empty();
            }
            var counter = 0;
            var node = leastRecentUsed;
            while (counter <= index) {
                counter++;
                node = node.getNext();
            }
            return of(node);
        }

        public Optional<LRUCacheNode<T>> getLeastRecentUsed() {
            if (isEmpty()) {
                return empty();
            }
            return of(leastRecentUsed.getNext());
        }

        public void remove(final LRUCacheNode<T> node) {
            final var next = node.getNext();
            final var previous = node.getPrevious();
            if (previous != null) {
                previous.setNext(next);
            }
            if (next != null) {
                next.setPrevious(previous);
            }
        }

        @Override
        public boolean equals(final Object other) {
            if (other instanceof LRUDoubleLinkedList) {
                final var otherList = (LRUDoubleLinkedList<?>) other;
                final var otherNodes = otherList.getAllNodes()
                        .stream()
                        .map(LRUCacheNode::getValue)
                        .collect(toList());
                final var nodes = getAllNodes()
                        .stream()
                        .map(LRUCacheNode::getValue)
                        .collect(toList());
                return nodes.equals(otherNodes);
            }
            return false;
        }

        @Override
        public String toString() {
            return getAllNodes().toString();
        }

        private Collection<LRUCacheNode<T>> getAllNodes() {
            final var nodes = new ArrayList<LRUCacheNode<T>>();
            getAllNodes(leastRecentUsed.getNext(), nodes);
            return nodes;
        }

        private void getAllNodes(final LRUCacheNode<T> node, final Collection<LRUCacheNode<T>> nodes) {
            if (node.getNext() == null) {
                return;
            }
            nodes.add(node);
            getAllNodes(node.getNext(), nodes);
        }
    }
}


