package edu.wz.cs.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum I (no duplicates, can use the same element multiple times) Recursion Backtrack Template
 */
public class CombinationSumI {
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
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
                list.add(nums[i]);
                backtrack(nums, i, target - nums[i], list, result);  // not i + 1 because we can reuse the same element
                list.remove(list.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 7};
        CombinationSumI combinationSum = new CombinationSumI();
        System.out.println(combinationSum.combinationSum(nums, 7));
    }

}
