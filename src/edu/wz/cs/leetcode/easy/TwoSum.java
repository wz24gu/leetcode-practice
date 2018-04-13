package edu.wz.cs.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum<br>
 * https://leetcode.com/problems/two-sum<br><br>
 * 
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.<br>
 * 
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {
    
    public static int[] solution(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int k = target - nums[i];
            if (map.containsKey(k)) {
                result[0] = map.get(k);
                result[1] = i;
            }
            else {
                map.put(nums[i], i);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(TwoSum.solution(nums, 9)));
    }

}
