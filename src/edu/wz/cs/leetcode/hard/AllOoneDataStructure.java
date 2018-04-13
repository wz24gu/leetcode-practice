package edu.wz.cs.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 432. All O one Data Structure<br>
 * https://leetcode.com/problems/all-oone-data-structure<br><br>
 * 
 * Implement a data structure supporting the following operations:<br>
 * 1. Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty 
 * string.<br>
 * 2. Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If 
 * the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.<br>
 * 3. GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".<br>
 * 4. GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".<br>
 * 
 * Challenge: Perform all these in O(1) time complexity.
 */
public class AllOoneDataStructure {
    
    private Map<String, Integer> map;  // key -> level
    private Map<Integer, Set<String>> vals;  // level -> set of keys
    int max;  // max level
    int min;  // min level
    String maxKey;
    String minKey;
    
    /** Initialize your data structure here. */
    public AllOoneDataStructure() {
        map = new HashMap<String, Integer>();
        vals = new HashMap<Integer, Set<String>>();
        max = 0;
        min = 0;
        maxKey = "";
        minKey = "";
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        // add to key -> level map
        map.put(key, map.getOrDefault(map.get(key), 0) + 1);
        
        // add to level -> keys map
        int val = map.get(key);
        if (vals.get(val) == null) {
            vals.put(val, new HashSet<String>());
        }
        vals.get(val).add(key);
        
        // clean up level - 1 if it contains key
        if (vals.containsKey(val - 1) && vals.get(val - 1).contains(key)) {
            vals.get(val - 1).remove(key);
            if (vals.get(val - 1).isEmpty()) {
                vals.remove(val - 1);
            }
        }
        
        // update max
        if (map.get(key) > max) {
            max = map.get(key);
            maxKey = key;
        }
        // clean up min (level - 1)
        if (map.get(key) - 1 == min) {
            if (vals.get(min) == null || vals.get(min).isEmpty()) {
                min++;
                minKey = key;
            }
            else {
                minKey = vals.get(min).iterator().next();
            }
        }
        // if key is in level 1
        if (map.get(key) == 1) {
            min = 1;
            minKey = key;
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!map.containsKey(key)) {
            return;
        }        
        
        // key in the level 1
        if (map.get(key) == 1) {
            map.remove(key);
            vals.get(1).remove(key);
            if (!vals.get(1).isEmpty()) {
                min = 1;
                minKey = vals.get(1).iterator().next();
                if (max == 1) {
                    maxKey = minKey;
                }
            }
            else {
                vals.remove(1);
                if (!map.isEmpty()) {
                    int tempMin = Integer.MAX_VALUE;
                    for (Map.Entry<Integer, Set<String>> entry : vals.entrySet()) {
                        if (!entry.getValue().isEmpty()) {
                            tempMin = Math.min(tempMin, entry.getKey());
                        }
                    }
                    min = tempMin;
                    minKey = vals.get(min).iterator().next();
                }
                else {  // level -> keys map is empty
                    max = 0;
                    min = 0;
                }
            }
        }
        // key not in level 1
        else {
            map.put(key, map.get(key) - 1);
            
            int val = map.get(key);
            // clean up level + 1
            if (vals.containsKey(val + 1) && vals.get(val + 1).contains(key)) {
                vals.get(val + 1).remove(key);
                if (vals.get(val + 1).isEmpty()) {
                    vals.remove(val + 1);
                }
            }
            // clean up current level of key
            if (vals.get(val) == null) {
                vals.put(val, new HashSet<String>());
            }
            vals.get(val).add(key);
            
            // update max
            if (val + 1 == max) {
                if (vals.get(max) == null || vals.get(max).isEmpty()) {
                    max--;
                }                
                maxKey = vals.get(max).iterator().next();                
            }
            // update min
            if (val + 1 == min) {
                min--;
                minKey = key;
            }            
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (map.isEmpty()) {
            return "";
        }
        return maxKey;
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (map.isEmpty()) {
            return "";
        }
        return minKey;
    }

}
