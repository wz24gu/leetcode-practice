package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 486. Predict the Winner<br>
 * https://leetcode.com/problems/predict-the-winner<br><br>
 * 
 * Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the 
 * array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not 
 * be available for the next player. This continues until all the scores have been chosen. The player with the maximum 
 * score wins.<br>
 * 
 * Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his 
 * score.<br><br>
 * 
 * Note:<br>
 * 1. 1 <= length of the array <= 20.<br>
 * 2. Any scores in the given array are non-negative integers and will not exceed 10,000,000.<br>
 * 3. If the scores of both players are equal, then player 1 is still the winner.
 */
public class PredictTheWinner {

    public static boolean solution(int[] nums) {
        return helper(nums, 0, nums.length - 1) >= 0;
    }
    
    private static int helper(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        return Math.max(nums[start] - helper(nums, start + 1, end), nums[end] - helper(nums, start, end - 1));
    }
    
    public static boolean solutionDP(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(nums, 0, n - 1, dp) >= 0;
    }
    
    private static int helper(int[] nums, int start, int end, int[][] dp) {
        if (dp[start][end] == -1) {  // if dp[start][end] != -1, we have calculated it before
            if (start == end) {
                dp[start][end] = nums[start];
            }
            else {
                dp[start][end] = Math.max(nums[start] - helper(nums, start + 1, end, dp), nums[end] - helper(nums, start, end - 1, dp));
            }
        }
        
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        
        return dp[start][end];
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 5, 2};
        System.out.println(PredictTheWinner.solution(nums));
        System.out.println(PredictTheWinner.solutionDP(nums));
        
        int[] nums2 = {1, 5, 233, 7};
        System.out.println(PredictTheWinner.solution(nums2));
        System.out.println(PredictTheWinner.solutionDP(nums2));
    }

}
