package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. Largest Divisible Subset<br>
 * https://leetcode.com/problems/largest-divisible-subset<br><br>
 * 
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this 
 * subset satisfies: Si % Sj = 0 or Sj % Si = 0.<br>
 * 
 * If there are multiple solutions, return any subset is fine.
 */
public class LargestDivisibleSubset {
    
    public static List<Integer> solution(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        // defensive copy
        int n = nums.length;
        int[] copy = new int[n];
        for (int i = 0; i < n; i++) {
            copy[i] = nums[i];
        }
        Arrays.sort(copy);
        
        int[] dp = new int[n];
        int[] parent = new int[n];
        int max = 0;
        int max_idx = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (copy[j] % copy[i] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
                if (max < dp[i]) {
                    max = dp[i];
                    max_idx = i;
                }
            }
        }
        
        for (int i = 0; i < max; i++) {
            result.add(copy[max_idx]);
            max_idx = parent[max_idx];
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(LargestDivisibleSubset.solution(nums));
        
        int[] nums2 = {1, 2, 4, 8};
        System.out.println(LargestDivisibleSubset.solution(nums2));
    }

}
