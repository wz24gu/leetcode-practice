package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 381. Insert Delete GetRandom O(1) - Duplicates allowed<br/>
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed<br/><br/>
 * 
 * Design a data structure that supports all following operations in average O(1) time.<br/>
 * 
 * Note: Duplicate elements are allowed.<br/>
 * 1. insert(val): Inserts an item val to the collection.<br/>
 * 2. remove(val): Removes an item val from the collection if present.<br/>
 * 3. getRandom: Returns a random element from current collection of elements. The probability of each element being 
 * returned is linearly related to the number of same value the collection contains.
 */
public class InsertDeleteGetRandomDuplicatesAllowed {
    
    private List<Integer> nums;
    private Map<Integer, Set<Integer>> map;
    private Random random;
    
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomDuplicatesAllowed() {
        nums = new ArrayList<Integer>();
        map = new HashMap<Integer, Set<Integer>>();
        random = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = map.containsKey(val);
        if (!contains) {
            map.put(val, new HashSet<Integer>());
        }
        map.get(val).add(nums.size());
        nums.add(val);
        return !contains;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        
        if (!map.get(val).contains(nums.size() - 1)) {
            int currPos = map.get(val).iterator().next();
            int lastVal = nums.get(nums.size() - 1);
            map.get(lastVal).remove(nums.size() - 1);
            map.get(lastVal).add(currPos);
            map.get(val).remove(currPos);
            map.get(val).add(nums.size() - 1);
            nums.set(currPos, lastVal);
        }
        
        map.get(val).remove(nums.size() - 1);
        if (map.get(val).isEmpty()) {
            map.remove(nums.size() - 1);
        }
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }    

}
