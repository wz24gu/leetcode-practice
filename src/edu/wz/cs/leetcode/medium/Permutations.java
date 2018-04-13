package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations<br>
 * https://leetcode.com/problems/permutations<br><br>
 * 
 * Given a collection of distinct numbers, return all possible permutations.
 */
public class Permutations {
    
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int n = nums.length;
        boolean[] marked = new boolean[n];
        List<Integer> list = new ArrayList<>();        
        backtrack(nums, 0, marked, list, result);
        return result;
    }
    
    private static void backtrack(int[] nums, int k, boolean[] marked, List<Integer> list, List<List<Integer>> result) {
        if (k == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!marked[i]) {
                marked[i] = true;
                list.add(nums[i]);
                backtrack(nums, k + 1, marked, list, result);
                list.remove(list.size() - 1);
                marked[i] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(Permutations.solution(nums));
    }

}
