package edu.wz.cs.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination II (with duplicates) Recursion Backtrack Template
 */
public class CombinationII {
    
    // TODO: not correct, need improvement
    public List<List<Integer>> combinationUniqe(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || k > nums.length) {
            return result;
        }
        
        Arrays.sort(nums);
        int[] dedup = dedup(nums);
        
        List<Integer> list = new ArrayList<>();
        backtrack(dedup, 0, k, list, result);
        return result;
    }
    
    private void backtrack(int[] nums, int start, int k, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(new ArrayList<Integer>(list));
        }
        else if (list.size() > k) {
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            
            list.add(nums[i]);
            backtrack(nums, i + 1, k, list, result);
            list.remove(list.size() - 1);
        }        
    }
    
    private int[] dedup(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            }
            list.add(nums[i]);
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 4, 5, 6, 6, 7};
        CombinationII combination = new CombinationII();
        System.out.println(combination.combinationUniqe(nums, 3));
        System.out.println(combination.combinationUniqe(nums, 3).size());
    }

}
