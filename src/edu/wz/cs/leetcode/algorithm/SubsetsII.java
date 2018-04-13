package edu.wz.cs.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Subsets II (with duplicates) Recursion Backtrack Template
 */
public class SubsetsII {
    
    public List<List<Integer>> subsetsUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        
        List<Integer> list = new ArrayList<>();
        backtrack(nums, 0, list, result);
        return result;
    }
    
    private void backtrack(int[] nums, int start, List<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(list));
        
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;  // ignore duplicates
            }
            list.add(nums[i]);
            backtrack(nums, i + 1, list, result);
            list.remove(list.size() - 1);
        }
        
    }

}
