package edu.wz.cs.leetcode.medium;

/**
 * 55. Jump Game<br>
 * https://leetcode.com/problems/jump-game<br><br>
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.<br>
 * 
 * Each element in the array represents your maximum jump length at that position.<br>
 * 
 * Determine if you are able to reach the last index.<br><br>
 * 
 * For example:<br>
 * A = [2,3,1,1,4], return true.<br>
 * A = [3,2,1,0,4], return false.
 */
public class JumpGame {
    
    public static boolean solutionDP(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1], nums[i-1]) - 1;
            if (dp[i] < 0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean solutionX(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i > max || max >= n - 1) {
                break;
            }
            max = Math.max(max, i + nums[i]);
        }
        return max >= n - 1;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(JumpGame.solutionDP(nums));
        System.out.println(JumpGame.solutionX(nums));
        
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(JumpGame.solutionDP(nums2));
        System.out.println(JumpGame.solutionX(nums2));
    }

}
