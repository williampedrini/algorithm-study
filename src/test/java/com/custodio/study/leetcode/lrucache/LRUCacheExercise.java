package com.custodio.study.leetcode.lrucache;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href="https://leetcode.com/problems/lru-cache/">Leet Code</a>
 */
public class LRUCacheExercise {

    @Test
    public void example1() {
        //given
        final var cache = new LRUCache(2);
        {
            //when
            final var actual = cache.get(2);
            //then
            assertEquals(-1, actual);
        }
        cache.put(2, 6);
        {
            //when
            final var actual = cache.get(1);
            //then
            assertEquals(-1, actual);
        }
        cache.put(1, 5);
        cache.put(1, 2);
        {
            //when
            final var actual = cache.get(1);
            //then
            assertEquals(2, actual);
        }
        {
            //when
            final var actual = cache.get(2);
            //then
            assertEquals(6, actual);
        }
    }

    static class LRUCache {
        private final int capacity;
        private final Map<Integer, Integer> values = new HashMap<>();
        private final Deque<Integer> keys = new ArrayDeque<>();

        public LRUCache(final int capacity) {
            this.capacity = capacity;
        }

        public int get(final int key) {
            final var value = values.getOrDefault(key, -1);
            if (value > -1) {
                keys.remove(key);
                keys.add(key);
            }
            return value;
        }

        public void put(final int key, final int value) {
            values.put(key, value);
            keys.remove(key);
            keys.add(key);
            if (values.size() > capacity) {
                values.remove(keys.remove());
            }
        }
    }
}


