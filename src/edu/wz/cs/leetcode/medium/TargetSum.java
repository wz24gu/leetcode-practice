package edu.wz.cs.leetcode.medium;

/**
 * 494. Target Sum<br>
 * https://leetcode.com/problems/target-sum<br><br>
 * 
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For 
 * each integer, you should choose one from + and - as its new symbol.<br>
 * 
 * Find out how many ways to assign symbols to make sum of integers equal to target S.<br><br>
 * 
 * Note:<br>
 * 1. The length of the given array is positive and will not exceed 20.<br>
 * 2. The sum of elements in the given array will not exceed 1000.<br>
 * 3. Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class TargetSum {
    
    private static int result;
    
    public static int solution(int[] nums, int sum) {
        result = 0;
        helper(nums, sum, 0);
        return result;
    }
    
    private static void helper(int[] nums, int sum, int start) {
        if (start >= nums.length) {
            if (sum == 0) {
                result++;
            }
            return;
        }
        
        helper(nums, sum - nums[start], start + 1);
        helper(nums, sum + nums[start], start + 1);
    }
    
    public static int solutionDP(int[] nums, int s) {
        int n = nums.length;
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (s > sum || s < -sum) {
            return 0;
        }
        
        int[] dp = new int[sum * 2 + 1];  // from -sum to sum (and 0)
        dp[sum] = 1;
        for (int i = 0; i < n; i++) {
            int[] next = new int[sum * 2 + 1];
            for (int k = 0; k < sum * 2 + 1; k++) {
                if (dp[k] != 0) {
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        
        return dp[sum + s];
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(TargetSum.solution(nums, 3));
        System.out.println(TargetSum.solutionDP(nums, 3));
    }

}
