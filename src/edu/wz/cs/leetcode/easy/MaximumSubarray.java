package edu.wz.cs.leetcode.easy;

/**
 * 53. Maximum Subarray<br>
 * https://leetcode.com/problems/maximum-subarray<br><br>
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.<br>
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
    
    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int n : nums) {
            sum = Math.max(sum + n, n);
            result = Math.max(result, sum);
        }
        
        return result;
    }
    
    public static int solutionDP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = nums[0];
        
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(MaximumSubarray.solution(nums));
        System.out.println(MaximumSubarray.solutionDP(nums));
    }

}
