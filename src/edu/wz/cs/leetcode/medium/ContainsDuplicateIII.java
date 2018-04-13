package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 220. Contains Duplicate III<br>
 * https://leetcode.com/problems/contains-duplicate-iii<br><br>
 * 
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute 
 * difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 */
public class ContainsDuplicateIII {
    
    public static boolean solution(int[] nums, int k, int t) {
        if (nums == null || nums.length == 1 || k == 0) {
            return false;
        }
        
        TreeSet<Long> tree = new TreeSet<>();
        int i = 0;
        while (i < nums.length) {
            Long floor = tree.floor((long) nums[i]);
            Long ceiling = tree.ceiling((long) nums[i]);
            if (floor != null && nums[i] - floor <= t
                    || ceiling != null && ceiling - nums[i] <= t) {
                return true;
            }
            
            tree.add((long) nums[i++]);
            if (i > k) {
                tree.remove((long) nums[i - k - 1]);
            }
        }
        
        return false;   
    }
    
    public static boolean solutionAlt(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }
        
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long num = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = num / (long) t + 1;
            if (map.containsKey(bucket)
                    || map.containsKey(bucket + 1) && num - map.get(bucket + 1) <= t
                    || map.containsKey(bucket - 1) && num - map.get(bucket - 1) <= t) {
                return true;
            }
            
            if (map.size() == k) {
                long last = ((long) nums[i-k] - Integer.MIN_VALUE);
                map.remove(last);
            }
            map.put(bucket, num);
        }
        
        return false;
    }    
    
    public static void main(String[] args) {
        
    }

}
