package com.custodio.study.leetcode.lrucache;

import com.custodio.study.leetcode.lrucache.LRUDoubleLinkedListTest.LRUDoubleLinkedList;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/lru-cache/">Leet Code</a>
 */
public class LRUCacheTest {

    @Test
    public void example1() {
        //given
        final var cache = new LRUCache(2);
        //when
        cache.put(1, 1);
        cache.put(2, 2);
        {
            final var actual = cache.get(1);
            //then
            final var expected = 1;
            assertEquals(expected, actual);
        }
        cache.put(3, 3);
        {
            final var actual = cache.get(2);
            //then
            final var expected = -1;
            assertEquals(expected, actual);
        }
        cache.put(4, 4);
        {
            final var actual = cache.get(1);
            //then
            final var expected = -1;
            assertEquals(expected, actual);
        }
        {
            final var actual = cache.get(3);
            //then
            final var expected = 3;
            assertEquals(expected, actual);
        }
        {
            final var actual = cache.get(4);
            //then
            final var expected = 4;
            assertEquals(expected, actual);
        }
    }

    public static class LRUCache {
        private final LRUDoubleLinkedList<LRUCacheValue> keys;
        private final Map<Integer, LRUCacheNode<LRUCacheValue>> cache;
        private final int capacity;

        public LRUCache(final int capacity) {
            this.capacity = capacity;
            this.keys = new LRUDoubleLinkedList<>();
            this.cache = new HashMap<>();
        }

        public int get(final int key) {
            final var node = cache.get(key);
            if (node == null) {
                return -1;
            }
            keys.remove(node);
            keys.add(node);
            return node
                    .getValue()
                    .getValue();
        }

        public void put(final int key, final int value) {
            final var defaultValue = new LRUCacheNode<>(new LRUCacheValue(key, value));
            final var node = cache.getOrDefault(key, defaultValue);
            cache.put(key, node);
            keys.remove(node);
            keys.add(node);
            if (cache.size() > capacity) {
                keys.getLeastRecentUsed().ifPresent(leastRecentUsed -> {
                    keys.remove(leastRecentUsed);
                    cache.remove(leastRecentUsed.getValue().getKey());
                });
            }
        }
    }

    public static class LRUCacheValue {
        private final int key;
        private final int value;

        public LRUCacheValue(final int key, final int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }
}