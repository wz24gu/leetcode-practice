package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 659. Split Array into Consecutive Subsequences<br/>
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences<br/><br/>
 * 
 * You are given an integer array sorted in ascending order (may contain duplicates), you need to split them into 
 * several subsequences, where each subsequences consist of at least 3 consecutive integers. Return whether you can make 
 * such a split.
 */
public class SplitArrayIntoConsecutiveSubsequences {

    public static boolean solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        Map<Integer, Integer> need = new HashMap<>();
        for (int num : nums) {
            if (!freq.containsKey(num) || freq.get(num) == 0) {
                continue;
            }
            else if (need.containsKey(num) && need.get(num) > 0) {
                need.put(num, need.get(num) - 1);
                need.put(num + 1, need.getOrDefault(num + 1, 0) + 1);
            }
            else if (freq.containsKey(num + 1) && freq.get(num + 1) > 0
                    && freq.containsKey(num + 2) && freq.get(num + 2) > 0) {
                freq.put(num + 1, freq.get(num + 1) - 1);
                freq.put(num + 2, freq.get(num + 2) - 1);
                need.put(num + 3, need.getOrDefault(num + 3, 0) + 1);
            }
            else {
                return false;
            }
            
            freq.put(num, freq.get(num) - 1);
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 5};
        System.out.println(SplitArrayIntoConsecutiveSubsequences.solution(nums));
        
        int[] nums2 = {1, 2, 3, 3, 4, 4, 5, 5};
        System.out.println(SplitArrayIntoConsecutiveSubsequences.solution(nums2));
        
        int[] nums3 = {1, 2, 3, 4, 4, 5};
        System.out.println(SplitArrayIntoConsecutiveSubsequences.solution(nums3));
    }
    
}
