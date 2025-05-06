package org.algorithms.and.data.structures.hash.map.or.set;
// https://leetcode.com/problems/lru-cache/description/

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LRUCache {
    private final int capacity;
    private final HashMap<Integer, Integer> cache = new HashMap<>();
    private final LinkedHashSet<Integer> usage = new LinkedHashSet<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        usage.remove(key);
        usage.add(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            usage.remove(key);

        } else if (cache.size() >= capacity) {
            int lruKey = usage.iterator().next();
            usage.remove(lruKey);
            cache.remove(lruKey);
        }

        cache.put(key, value);
        usage.add(key);
    }

    public static void main(String[] args) {
        var lruCache = new LRUCache(2);
        var lruCache2 = new LRUCache(2);
        var lruCache3 = new LRUCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

        System.out.println(lruCache2.get(2));
        lruCache2.put(2, 6);
        System.out.println(lruCache2.get(1));
        lruCache2.put(1, 5);
        lruCache2.put(1, 2);
        System.out.println(lruCache2.get(1));
        System.out.println(lruCache2.get(2));

        lruCache3.put(2, 1);
        lruCache3.put(1, 1);
        lruCache3.put(2, 3);
        lruCache3.put(4, 1);
        System.out.println(lruCache3.get(1));
        System.out.println(lruCache3.get(2));
    }
}
