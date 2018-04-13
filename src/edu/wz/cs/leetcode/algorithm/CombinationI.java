package edu.wz.cs.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination I (no duplicate) Recursion Backtrack Template
 */
public class CombinationI {
    
    public List<List<Integer>> combination(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || k > nums.length) {
            return result;
        }
        
        List<Integer> list = new ArrayList<>();
        backtrack(nums, 0, k, list, result);
        return result;        
    }
    
    private void backtrack(int[] nums, int start, int k, List<Integer> list, List<List<Integer>> result) {
        if (list.size() > k) {
            return;
        }        
        else if (list.size() == k) {
            result.add(new ArrayList<Integer>(list));
        }        
        else {        
            for (int i = start; i < nums.length; i++) {
                list.add(nums[i]);
                backtrack(nums, i + 1, k, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        CombinationI combination = new CombinationI();
        System.out.println(combination.combination(nums, 3));
        System.out.println(combination.combination(nums, 3).size());
    }

}
