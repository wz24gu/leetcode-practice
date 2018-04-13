package edu.wz.cs.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Subsets I (no duplicates) Recursion Backtrack Template
 */
public class SubsetsI {
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        List<Integer> list = new ArrayList<>();
        backtrack(nums, 0, list, result);
        return result;        
    }
    
    private void backtrack(int[] nums, int start, List<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(list));
        
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 1, 3};
        SubsetsI subsets = new SubsetsI();
        System.out.println(subsets.subsets(nums));
        
    }

}
