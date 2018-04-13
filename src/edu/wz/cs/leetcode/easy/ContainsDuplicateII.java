package edu.wz.cs.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 219. Contains Duplicate II<br>
 * https://leetcode.com/problems/contains-duplicate-ii<br><br>
 * 
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array 
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
public class ContainsDuplicateII {
    
    public static boolean solution(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(i - map.get(nums[i])) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        
        return false;
    }
    
    public static boolean solutionX(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > k) {
                set.remove(nums[i-k-1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 3};
        System.out.println(ContainsDuplicateII.solution(nums, 2));
    }

}
