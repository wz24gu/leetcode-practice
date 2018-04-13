package edu.wz.cs.leetcode.medium;

/**
 * 213. House Robber II<br>
 * https://leetcode.com/problems/house-robber-ii<br><br>
 * 
 * Note: This is an extension of House Robber.<br>
 * 
 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will 
 * not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house 
 * is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the 
 * previous street.<br>
 * 
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of 
 * money you can rob tonight without alerting the police.
 */
public class HouseRobberII {
    
    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
    }
    
    private static int helper(int[] nums, int start, int end) {
        int prev = 0;
        int curr = 0;
        for (int i = start; i <= end; i++) {
            int t = curr;
            curr = Math.max(prev + nums[i], curr);
            prev = t;
        }
        return curr;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5};
        System.out.println(HouseRobberII.solution(nums));
    }

}
