package edu.wz.cs.leetcode.hard;

import java.util.Arrays;

/**
 * 410. Split Array Largest Sum<br>
 * https://leetcode.com/problems/split-array-largest-sum<br><br>
 * 
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty 
 * continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.<br><br>
 * 
 * Note: If n is the length of array, assume the following constraints are satisfied:<br>
 * 1. 1 <= n <= 1000<br>
 * 2. 1 <= m <= min(50, n)
 */
public class SplitArrayLargestSum {
    
    public static int solution(int[] nums, int m) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            left = Math.max(left, nums[i]);  // left is the max of a single element
            right += nums[i];  // right is the sum of all elements
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (split(nums, m, mid)) {
               right = mid; 
            }
            else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private static boolean split(int[] nums, int m, int sum) {
        int count = 1;
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];
            if (curr > sum) {
                curr = nums[i];
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static int solutionDP(int[] nums, int m) {
        int n = nums.length;
        int[] sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = i - 1; k < j; k++) {
                    int val = Math.max(dp[i-1][k], sum[j] - sum[k]);
                    dp[i][j] = Math.min(dp[i][j], val);
                }
            }
        }
        
        return dp[m][n];
    }
    
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        System.out.println(SplitArrayLargestSum.solution(nums, 2));
        System.out.println(SplitArrayLargestSum.solutionDP(nums, 2));
    }

}
