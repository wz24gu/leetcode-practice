package edu.wz.cs.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutation I (no duplicates) Recursion Backtrack Template
 */
public class PermutationI {
    
    public List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int len = nums.length;
        boolean[] used = new boolean[len];
        List<Integer> list = new ArrayList<>();
        
        backtrack(nums, used, list, result);
        return result;
    }
    
    private void backtrack(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                list.add(nums[i]);
                used[i] = true;
                backtrack(nums, used, list, result);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }

}
