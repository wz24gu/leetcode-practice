package edu.wz.cs.leetcode.medium;

/**
 * 713. Subarray Product Less Than K<br>
 * https://leetcode.com/problems/subarray-product-less-than-k<br><br>
 * 
 * Your are given an array of positive integers nums.<br>
 * 
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less 
 * than k.<br>
 * 
 * Note:<br>
 * 1. 0 < nums.length <= 50000.<br>
 * 2. 0 < nums[i] < 1000.<br>
 * 3. 0 <= k < 10 ^ 6.
 */
public class SubarrayProductLessThanK {
    
    public static int solution(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        
        int res = 0;
        int product = 1;
        int left = 0;
        
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left++];
            }
            res += right - left + 1;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        System.out.println(SubarrayProductLessThanK.solution(nums, 100));
    }

}
