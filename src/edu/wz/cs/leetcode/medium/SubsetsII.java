package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II<br>
 * https://leetcode.com/problems/subsets-ii<br><br>
 * 
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).<br>
 * 
 * Note: The solution set must not contain duplicate subsets.
 */
public class SubsetsII {
    
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        
        List<Integer> list = new ArrayList<>();
        backtrack(nums, 0, list, result);
        return result;
    }
    
    private static void backtrack(int[] nums, int start, List<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(list));
        
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            list.add(nums[i]);
            backtrack(nums, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(SubsetsII.solution(nums));
    }

}
