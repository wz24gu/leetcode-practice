package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 677. Map Sum Pairs<br>
 * https://leetcode.com/problems/map-sum-pairs<br><br>
 * 
 * Implement a MapSum class with insert, and sum methods. For the method insert, you'll be given a pair of (string,
 * integer). The string represents the key and the integer represents the value. If the key already existed, then the
 * original key-value pair will be overridden to the new one. For the method sum, you'll be given a string representing
 * the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.
 */
public class MapSumPairs {
    
    private Map<String, Integer> map1;
    private Map<String, Integer> map2;
    
    public MapSumPairs() {
        map1 = new HashMap<String, Integer>();
        map2 = new HashMap<String, Integer>();
    }
    
    public void insert(String key, int val) {
        int diff = 0;
        if (map1.containsKey(key)) {
            diff = map1.get(key) - val;
        }
        else {
            diff = val;
        }
        
        map1.put(key, val);
        
        int n = key.length();
        for (int i = 1; i < n; i++) {
            String sub = key.substring(0, i);
            if (map2.containsKey(sub)) {
                map2.put(sub, map2.get(sub) + diff);
            }
            else {
                map2.put(sub, diff);
            }
        }
    }
    
    public int sum(String prefix) {
        if (map1.containsKey(prefix) && map2.containsKey(prefix)) {
            return map1.get(prefix);
        }
        else if (map1.containsKey(prefix)) {
            return map1.get(prefix);
        }
        else if (map2.containsKey(prefix)) {
            return map2.get(prefix);
        }
        else {
            return 0;
        }
    }
    
    public static void main(String[] args) {
        MapSumPairs msp = new MapSumPairs();
        msp.insert("apple", 3);
        System.out.println(msp.sum("apple"));
        System.out.println(msp.sum("ap"));
        msp.insert("app", 2);
        System.out.println(msp.sum("app"));
        System.out.println(msp.sum("ap"));   
    }

}
