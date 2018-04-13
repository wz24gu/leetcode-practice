package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 491. Increasing Subsequences<br>
 * https://leetcode.com/problems/increasing-subsequences<br><br>
 * 
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, 
 * and the length of an increasing subsequence should be at least 2.<br><br>
 * 
 * Note:<br>
 * 1. The length of the given array will not exceed 15.<br>
 * 2. The range of integer in the given array is [-100,100].<br>
 * 3. The given array may contain duplicates, and two equal integers should also be considered as a special case of 
 * increasing sequence.
 */
public class IncreasingSubsequences {
    
    public static List<List<Integer>> solution(int[] nums) {        
        if (nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> out = new ArrayList<>();
        helper(nums, 0, out, set);
        return new ArrayList<>(set);
    }
    
    private static void helper(int[] nums, int index, List<Integer> out, Set<List<Integer>> set) {
        if (out.size() >= 2) {
            set.add(new ArrayList<Integer>(out));
        }
        
        for (int i = index; i < nums.length; i++) {
            if (out.size() == 0 || out.get(out.size() - 1) <= nums[i]) {
                out.add(nums[i]);
                helper(nums, i + 1, out, set);
                out.remove(out.size() - 1);
            }
        }        
    }
    
    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        System.out.println(IncreasingSubsequences.solution(nums));
    }

}
