package edu.wz.cs.leetcode.easy;

/**
 * 643. Maximum Average Subarray I<br>
 * https://leetcode.com/problems/maximum-average-subarray-i<br><br>
 * 
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average 
 * value. And you need to output the maximum average value.<br>
 * 
 * Example 1:<br>
 * Input: [1,12,-5,-6,50,3], k = 4<br>
 * Output: 12.75<br>
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75<br><br>
 * 
 * Note:<br>
 * 1. 1 <= k <= n <= 30,000.<br>
 * 2. Elements of the given array will be in the range [-10,000, 10,000].
 */
public class MaximumAverageSubarrayI {
    
    public static double solution(int[] nums, int k) {        
        double sum = 0.0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        
        double max = sum;
        int i = 0;  // tricky pointer
        int j = k;  // tricky pointer
        while (j < nums.length) {
            sum = sum - nums[i] + nums[j];
            max = Math.max(max, sum);
            i++;
            j++;
        }
        return max / k;
    }
    
    public static double solutionAlt(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        
        double max = sum[k-1];
        for (int i = k; i < n; i++) {
            max = Math.max(max, sum[i] - sum[i-k]);
        }
        return max / k;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        System.out.println(MaximumAverageSubarrayI.solution(nums, 4));
        System.out.println(MaximumAverageSubarrayI.solutionAlt(nums, 4));
    }

}
