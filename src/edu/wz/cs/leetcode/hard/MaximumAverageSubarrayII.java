package edu.wz.cs.leetcode.hard;

/**
 * 644. Maximum Average Subarray II<br>
 * https://leetcode.com/problems/maximum-average-subarray-ii<br><br>
 * 
 * Given an array consisting of n integers, find the contiguous subarray whose length is greater than or equal to k that 
 * has the maximum average value. And you need to output the maximum average value.<br>
 * 
 * Example 1: Input: [1,12,-5,-6,50,3], k = 4; Output: 12.75<br>
 * Explanation:<br>
 * when length is 5, maximum average value is 10.8,<br>
 * when length is 6, maximum average value is 9.16667.<br>
 * Thus return 12.75.<br><br>
 * 
 * Note:<br>
 * 1. 1 <= k <= n <= 10,000.<br>
 * 2. Elements of the given array will be in range [-10,000, 10,000].<br>
 * 3. The answer with the calculation error less than 10-5 will be accepted.
 */
public class MaximumAverageSubarrayII {
    
    public static double solution(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        
        double result = sum[k-1] / k;  // first k elements
        
        for (int i = k; i < n; i++) {
            double t = sum[i];
            if (t > result * (i + 1)) {
                result = t / (i + 1);
            }
            
            for (int j = i - k; j >= 0; j--) {
                t = sum[i] - sum[j];
                if (t > result * (i - j)) {
                    result = t / (i - j);
                }
            }
        }
        
        return result;
    }
    
    public static double solutionBinarySearch(int[] nums, int k) {
        int n = nums.length;
        double[] sum = new double[n+1];
        
        double lo = Double.POSITIVE_INFINITY;
        double hi = Double.NEGATIVE_INFINITY;
        for (int num : nums) {
            lo = Math.min(lo, num);
            hi = Math.max(hi, num);
        }
        
        while (hi - lo > 1e-5) {
            double minSum = 0;
            double mid = lo + (hi - lo) / 2;
            boolean check = false;
            for (int i = 1; i <= n; i++) {
                sum[i] = sum[i-1] + nums[i-1] - mid;
                if (i >= k) {
                    minSum = Math.min(minSum, sum[i-k]);
                }
                if (i > k && sum[i] > minSum) {
                    check = true;
                    break;
                }
            }
            if (check) {
                lo = mid;
            }
            else {
                hi = mid;
            }
        }
        
        return lo;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        System.out.println(MaximumAverageSubarrayII.solution(nums, 4));
        System.out.println(MaximumAverageSubarrayII.solutionBinarySearch(nums, 4));
    }

}
