package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 380. Insert Delete GetRandom O(1)<br>
 * https://leetcode.com/problems/insert-delete-getrandom-o1<br><br>
 * 
 * Design a data structure that supports all following operations in average O(1) time.<br>
 * 1. insert(val): Inserts an item val to the set if not already present.<br>
 * 2. remove(val): Removes an item val from the set if present.<br>
 * 3. getRandom: Returns a random element from current set of elements. Each element must have the same probability of 
 * being returned.
 */
public class InsertDeleteGetRandom {
    
    List<Integer> list;
    Map<Integer, Integer> map;
    Random rand;    
    
    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        
        map.put(val, list.size());
        list.add(val);
        return true;        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        
        int index = map.get(val);
        if (index != list.size() - 1) {
            int lastValue = list.get(list.size() - 1);
            list.set(index, lastValue);
            map.put(lastValue, index);
        }
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
    
    public static void main(String[] args) {
        InsertDeleteGetRandom random = new InsertDeleteGetRandom();
        System.out.println(random.insert(1));
        System.out.println(random.remove(2));
        System.out.println(random.insert(2));
        System.out.println(random.getRandom());
        System.out.println(random.remove(1));
        System.out.println(random.insert(2));
        System.out.println(random.getRandom());
    }

}
