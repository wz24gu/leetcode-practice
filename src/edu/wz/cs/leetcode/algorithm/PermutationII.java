package edu.wz.cs.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Permutation II (with duplicates) Recursion Backtrack Template
 */
public class PermutationII {
    
    public List<List<Integer>> permutationUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        
        int n = nums.length;
        boolean[] used = new boolean[n];
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
                if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) {
                    continue;  // ignore used and duplicates
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
