package edu.wz.cs.leetcode.algorithm;

public class Kadane {
    
    public int maxSubarray(int[] nums) {
        int max = nums[0];
        int n = nums.length;        
        
        int[] dp = new int[n];
        dp[0] = nums[0];
        
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            max = Math.max(max, dp[i]);
        }        
        return max;   
    }
    
    public int maxSubarrayX(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum = Math.max(num, sum + num);
            max = Math.max(max, sum);
        }
        return max;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, -3, 2, 1, -1};
        Kadane kadane = new Kadane();
        System.out.println(kadane.maxSubarray(nums));
        System.out.println(kadane.maxSubarrayX(nums));        
    }

}
