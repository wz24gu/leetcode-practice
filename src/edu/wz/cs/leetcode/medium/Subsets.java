package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets<br>
 * https://leetcode.com/problems/subsets<br><br>
 * 
 * Given a set of distinct integers nums, return all possible subsets (the power set).<br>
 * 
 * Note: The solution set must not contain duplicate subsets.
 */
public class Subsets {
    
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        List<Integer> list = new ArrayList<>();
        backtrack(nums, 0, list, result);
        return result;
    }
    
    private static void backtrack(int[] nums, int start, List<Integer> list, List<List<Integer>> result) {        
        result.add(new ArrayList<Integer>(list));
   
        for (int i = start; i < nums.length; i++) {            
            list.add(nums[i]);
            backtrack(nums, i + 1, list, result);
            list.remove(list.size() - 1);
        }        
    }    
    
    public static List<List<Integer>> solutionAlt(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }        
        
        result.add(new ArrayList<Integer>());        
        for (int i = 0; i < nums.length; i++) {            
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = new ArrayList<>(result.get(j));
                list.add(nums[i]);
                result.add(list);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(Subsets.solution(nums));
        System.out.println(Subsets.solutionAlt(nums));
    }

}
