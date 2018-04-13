package edu.wz.cs.leetcode.medium;

/**
 * 312. Burst Balloons<br>
 * https://leetcode.com/problems/burst-balloons<br><br>
 * 
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You 
 * are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
 * Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.<br>
 * 
 * Find the maximum coins you can collect by bursting the balloons wisely.<br><br>
 * 
 * Note:<br>
 * (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.<br>
 * (2) 0 <= n <= 500, 0 <= nums[i] <= 100
 */
public class BurstBalloons {
    
    public static int solution(int[] nums) {
        int n = nums.length;
        int[] copy = new int[n+2];
        copy[0] = copy[n+1] = 1;
        for (int i = 1; i <= n; i++) {
            copy[i] = nums[i-1];
        }
        
        int[][] dp = new int[n+2][n+2];
        for (int len = 1; len <= n; len++) {
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;
                for (int k = left; k <= right; k++) {
                    dp[left][right] = Math.max(dp[left][right], copy[left-1] * copy[k] * copy[right+1] + dp[left][k-1] + dp[k+1][right]);
                }                
            }
        }
        
        return dp[1][n];
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        System.out.println(BurstBalloons.solution(nums));
    }

}
