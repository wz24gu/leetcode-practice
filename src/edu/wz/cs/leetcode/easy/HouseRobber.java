package edu.wz.cs.leetcode.easy;

/**
 * 198. House Robber<br>
 * https://leetcode.com/problems/house-robber<br><br>
 * 
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money 
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system 
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.<br>
 * 
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount 
 * of money you can rob tonight without alerting the police.
 */
public class HouseRobber {
    
    public static int solution(int[] nums) {
        if (nums== null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        
        return dp[n-1];
    }
    
    public static void main(String[] args) {
        int[] houses = {3, 2, 1, 5};
        System.out.println(HouseRobber.solution(houses));
    }

}
