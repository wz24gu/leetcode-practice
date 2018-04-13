package edu.wz.cs.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum II (with duplicates, cannot reuse element) Recursion Backtrack Template
 */
public class CombinationSumII {
    
    public List<List<Integer>> combinationSumII(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        
        List<Integer> list = new ArrayList<>();
        backtrack(nums, 0, target, list, result);
        return result;
    }
    
    private void backtrack(int[] nums, int start, int target, List<Integer> list, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        else if (target == 0) {
            result.add(new ArrayList<Integer>(list));
        }
        else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i-1]) {
                    continue;  // ignore duplicates
                }
                
                list.add(nums[i]);
                backtrack(nums, i + 1, target - nums[i], list, result);  // i + 1, cannot reuse the element
                list.remove(list.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        CombinationSumII combinationSum = new CombinationSumII();
        System.out.println(combinationSum.combinationSumII(nums, 8));
    }

}
