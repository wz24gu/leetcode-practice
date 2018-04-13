package edu.wz.cs.leetcode.hard;

import java.util.LinkedHashMap;

/**
 * 146. LRU Cache<br>
 * https://leetcode.com/problems/lru-cache<br><br>
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: 
 * get and put.<br>
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.<br>
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
 * it should invalidate the least recently used item before inserting a new item.<br>
 * 
 * Follow up: Could you do both operations in O(1) time complexity?
 */
public class LRUCache {
    
    private int capacity;
    private LinkedHashMap<Integer, Integer> cache;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<Integer, Integer>();
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            int val = cache.get(key);
            cache.remove(key);
            cache.put(key, val);
            return val;
        }
        return -1;        
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key, value);
        }
        else {
            if (cache.size() == capacity) {
                cache.remove(cache.entrySet().iterator().next().getKey());                
            }
            cache.put(key, value);
        }
    }
    
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

}
