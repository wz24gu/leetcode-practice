package edu.wz.cs.leetcode.medium;

/**
 * 152. Maximum Product Subarray<br>
 * https://leetcode.com/problems/maximum-product-subarray<br><br>
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 */
public class MaximumProductSubarray {
    
    public static int solution(int[] nums) {
        int res = Integer.MIN_VALUE;
        
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = nums[0];
        g[0] = nums[0];
        
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(nums[i], Math.max(f[i-1] * nums[i], g[i-1] * nums[i]));
            g[i] = Math.min(nums[i], Math.min(f[i-1] * nums[i], g[i-1] * nums[i]));
            res = Math.max(res, f[i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(MaximumProductSubarray.solution(nums));
    }

}
