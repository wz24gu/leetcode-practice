package edu.wz.cs.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 170. Two Sum III - Data structure design<br>
 * https://leetcode.com/problems/two-sum-iii-data-structure-design<br><br>
 * 
 * Design and implement a TwoSum class. It should support the following operations:add and find.<br>
 * add - Add the number to an internal data structure.<br>
 * find - Find if there exists any pair of numbers which sum is equal to the value.<br>
 * 
 * For example,<br>
 * add(1); add(3); add(5);<br>
 * find(4) -> true<br>
 * find(7) -> false
 */
public class TwoSumIII {
    
    private Map<Integer, Integer> map;
    
    public TwoSumIII() {
        map = new HashMap<Integer, Integer>();
    }
    
    public void add(int num) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }
    
    public boolean find(int value) {
        if (map.isEmpty()) {
            return false;
        }
        
        for (int n : map.keySet()) {
            if (map.containsKey(value - n)) {
                if (value - n != n || map.get(value - n) > 1) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        TwoSumIII twoSum = new TwoSumIII();
        twoSum.add(0);
        twoSum.add(-1);
        twoSum.add(1);
        System.out.println(twoSum.find(0));        
    }

}
