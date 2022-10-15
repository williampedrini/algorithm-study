package com.custodio.study.leetcode.lrucache;

public class LRUCacheNode<T> {
    private final T value;
    private LRUCacheNode<T> previous;
    private LRUCacheNode<T> next;

    public LRUCacheNode() {
        this(null);
    }

    public LRUCacheNode(final T value) {
        this(value, null, null);
    }

    public LRUCacheNode(final T value,
                        final LRUCacheNode<T> previous,
                        final LRUCacheNode<T> next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public LRUCacheNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(final LRUCacheNode<T> previous) {
        this.previous = previous;
    }

    public LRUCacheNode<T> getNext() {
        return next;
    }

    public void setNext(final LRUCacheNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
