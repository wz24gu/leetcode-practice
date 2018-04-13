package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II<br>
 * https://leetcode.com/problems/combination-sum-ii<br><br>
 * 
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the 
 * candidate numbers sums to T.<br>
 * 
 * Each number in C may only be used once in the combination.<br><br>
 * 
 * Note:<br>
 * 1. All numbers (including target) will be positive integers.<br>
 * 2. The solution set must not contain duplicate combinations.
 */
public class CombinationSumII {
    
    public static List<List<Integer>> solution(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        backtrack(candidates, 0, target, list, res);
        return res;
    }
    
    private static void backtrack(int[] candidates, int pos, int target, List<Integer> list, List<List<Integer>> res) {
        if (pos > candidates.length || target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = pos; i < candidates.length; i++) {
            if (i > pos && candidates[i] == candidates[i-1]) {
                continue;
            }
            list.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], list, res);
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(CombinationSumII.solution(candidates, 8));
    }

}
