package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum<br>
 * https://leetcode.com/problems/combination-sum<br><br>
 * 
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C 
 * where the candidate numbers sums to T.<br>
 * 
 * The same repeated number may be chosen from C unlimited number of times.<br><br>
 * 
 * Note:<br>
 * 1. All numbers (including target) will be positive integers.<br>
 * 2. The solution set must not contain duplicate combinations.
 */
public class CombinationSum {
    
    public static List<List<Integer>> solution(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        backtrack(nums, 0, target, list, result);
        return result;
    }
    
    private static void backtrack(int[] nums, int pos, int target, List<Integer> list, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }        
        
        int n = nums.length;
        for (int i = pos; i < n; i++) {
            list.add(nums[i]);
            backtrack(nums, i, target - nums[i], list, result);  // not i + 1 because we can reuse the element
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        System.out.println(CombinationSum.solution(nums, 7));
    }

}
