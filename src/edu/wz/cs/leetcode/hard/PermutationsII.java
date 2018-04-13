package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 47. Permutations II<br>
 * https://leetcode.com/problems/permutations-ii<br><br>
 * 
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 */
public class PermutationsII {
    
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        helper(nums, 0, result);
        return result;
    }
    
    private static void helper(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            result.add(temp);
            return;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.add(nums[i])) {
                swap(nums, index, i);
                helper(nums, index + 1, result);
                swap(nums, index, i);
            }
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }
    
    public static List<List<Integer>> solutionAlt(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        dfs(nums, used, list, result);
        return result;
    }
    
    private static void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }            
            if (i > 0 && nums[i-1] == nums[i] && !used[i-1]) {
                continue;
            }
            
            used[i] = true;
            list.add(nums[i]);
            dfs(nums, used, list, result);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(PermutationsII.solution(nums));
        System.out.println(PermutationsII.solutionAlt(nums));
    }

}
