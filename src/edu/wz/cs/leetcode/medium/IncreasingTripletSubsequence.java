package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 334. Increasing Triplet Subsequence<br>
 * https://leetcode.com/problems/increasing-triplet-subsequence<br><br>
 * 
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.<br>
 * 
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 */
public class IncreasingTripletSubsequence {
    
    public static boolean solutionDP(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] >= 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean solutionX(int[] nums) {
        int m1 = Integer.MAX_VALUE;
        int m2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (m1 >= num) {
                m1 = num;  // smallest
            }
            else if (m2 >= num) {
                m2 = num;  // 2nd smallest
            }
            else {
                return true;
            }            
        }
        return false;
    }
    
    public static boolean solutionAlt(int[] nums) {
        int n = nums.length;
        
        int[] forward = new int[n];
        forward[0] = nums[0];
        for (int i = 1; i < n; i++) {
            forward[i] = Math.min(forward[i-1], nums[i]);
        }
        
        int[] backward = new int[n];
        backward[n-1] = nums[n-1];
        for (int i = n - 2; i >= 0; i--) {
            backward[i] = Math.max(backward[i+1], nums[i]);
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > forward[i] && nums[i] < backward[i]) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(IncreasingTripletSubsequence.solutionDP(nums));
        System.out.println(IncreasingTripletSubsequence.solutionX(nums));
        System.out.println(IncreasingTripletSubsequence.solutionAlt(nums));
        
        int[] nums2 = {5, 4, 3, 2, 1};
        System.out.println(IncreasingTripletSubsequence.solutionDP(nums2));
        System.out.println(IncreasingTripletSubsequence.solutionX(nums2));
        System.out.println(IncreasingTripletSubsequence.solutionAlt(nums2));
    }

}
