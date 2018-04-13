package edu.wz.cs.leetcode.hard;

import java.util.Arrays;

/**
 * 689. Maximum Sum of 3 Non-Overlapping Subarrays<br>
 * 
 * In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum. Each subarray
 * will be of size k, and we want to maximize the sum of all 3*k entries. Return the result as a list of indices
 * representing the starting position of each interval (0-indexed). If there are multiple answers, return the
 * lexicographically smallest one.<br><br>
 * 
 * Note:<br>
 * 1. nums.length will be between 1 and 20000.<br>
 * 2. nums[i] will be between 1 and 65535.<br>
 * 3. k will be between 1 and floor(nums.length / 3).
 */
public class MaximumSumOfThreeNonOverlappingSubarrays {
    
    public static int[] solution(int[] nums, int k) {
        int[] result = new int[3];
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] sum = new int[n+1];        
        
        // initialize: get prefix rolling sum
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + nums[i-1];  // sum[0] = 0, sum[1] = nums[0], sum[2] = nums[0] + nums[1], ...
        }
        
        // left interval: left[0 .. k-1] = 0
        for (int i = k, total = sum[k] - sum[0]; i < n; i++) {
            if (total < sum[i+1] - sum[i-k+1]) {
                total = sum[i+1] - sum[i-k+1];
                left[i] = i - k + 1;
            }
            else {
                left[i] = left[i-1];
            }
        }
        
        // right interval
        right[n-k] = n - k;
        for (int i = n - k - 1, total = sum[n] - sum[n-k]; i >= 0; i--) {
            if (total <= sum[i+k] - sum[i]) {  // careful of the <= to find the leftmost index
                total = sum[i+k] - sum[i];
                right[i] = i;
            }
            else {
                right[i] = right[i+1];
            }
        }
        
        // middle interval
        int max = 0;
        for (int i = k; i < n - 2 * k; i++) {  // range of i in the middle interval
            int l = left[i-1];  // initially l = 0
            int r = right[i+k];
            int total = sum[l+k] - sum[l] + sum[i+k] - sum[i] + sum[r+k] - sum[r];
            if (total > max) {
                max = total;
                result[0] = l;
                result[1] = i;
                result[2] = r;
            }
        }
        
        return result;
    }
    
    public static int[] solutionAlt(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = k - 1; i < n; i++) {
            int total = sum[i] - sum[i-k+1] + nums[i-k+1];
            if (total > max) {
                max = total;
                left[i] = i - k + 1;
            }
            else {
                left[i] = left[i-1];
            }
        }
        
        max = Integer.MIN_VALUE;
        for (int i = n - k; i >= 0; i--) {
            int total = sum[i+k-1] - sum[i] + nums[i];
            if (total >= max) {
                max = total;
                right[i] = i;
            }
            else {
                right[i] = right[i+1];
            }
        }
        
        int[] res = new int[3];
        max = Integer.MIN_VALUE;
        for (int i = k; i <= n - 2 * k; i++) {
            int l = left[i-1];
            int r = right[i+k];
            int total = sum[l+k-1] - sum[l] + nums[l];
            total += sum[i+k-1] - sum[i] + nums[i];
            total += sum[r+k-1] - sum[r] + nums[r];
            if (total > max) {
                max = total;
                res[0] = l;
                res[1] = i;
                res[2] = r;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 6, 7, 5, 1};
        System.out.println(Arrays.toString(MaximumSumOfThreeNonOverlappingSubarrays.solution(nums, 2)));
        System.out.println(Arrays.toString(MaximumSumOfThreeNonOverlappingSubarrays.solutionAlt(nums, 2)));
    }

}
