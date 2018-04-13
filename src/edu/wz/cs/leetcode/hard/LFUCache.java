package edu.wz.cs.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * 460. LFU Cache<br>
 * https://leetcode.com/problems/lfu-cache<br><br>
 * 
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following 
 * operations: get and put.<br>
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.<br>
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it 
 * should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when 
 * there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.<br>
 * 
 * Follow up: Could you do both operations in O(1) time complexity?
 */
public class LFUCache {
    
    private int capacity;
    private int min;
    private Map<Integer, Integer> map;
    private Map<Integer, Integer> count;
    private Map<Integer, Set<Integer>> level;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        min = -1;
        map = new HashMap<Integer, Integer>();
        count = new HashMap<Integer, Integer>();
        level = new HashMap<Integer, Set<Integer>>();
        level.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        int cnt = count.get(key);        
        level.get(cnt).remove(key);        
        if (cnt == min && level.get(cnt).size() == 0) {
            min++;
        }
        
        if (!level.containsKey(cnt + 1)) {
            level.put(cnt + 1, new LinkedHashSet<>());
        }
        level.get(cnt + 1).add(key);
        count.put(key, cnt + 1);
        
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        
        if (map.containsKey(key)) {
            map.put(key, value);
            get(key);
            return;
        }
        
        if (map.size() == capacity) {
            int discard = level.get(min).iterator().next();
            level.get(min).remove(discard);
            map.remove(discard);
            count.remove(discard);
        }
        map.put(key, value);
        count.put(key, 1);
        min = 1;
        level.get(1).add(key);
    }
    
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        
        LFUCache cache2 = new LFUCache(2);
        cache2.put(2, 1);
        cache2.put(3, 2);
        System.out.println(cache2.get(3));
        System.out.println(cache2.get(2));
        cache2.put(4, 3);
        System.out.println(cache2.get(2));
        System.out.println(cache2.get(3));        
        System.out.println(cache2.get(4));     
    }

}
