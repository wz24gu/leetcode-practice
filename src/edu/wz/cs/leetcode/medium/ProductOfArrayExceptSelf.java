package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 238. Product of Array Except Self<br>
 * https://leetcode.com/problems/product-of-array-except-self<br><br>
 * 
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product 
 * of all the elements of nums except nums[i].<br>
 * 
 * Solve it without division and in O(n).<br>
 * 
 * For example, given [1,2,3,4], return [24,12,8,6].<br>
 * 
 * Follow up:<br>
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the 
 * purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {
    
    public static int[] solution(int[] nums) {
        int n = nums.length;
        
        int[] forward = new int[n];
        forward[0] = nums[0];
        for (int i = 1; i < n; i++) {
            forward[i] = forward[i-1] * nums[i];
        }
        
        int[] backward = new int[n];
        backward[n-1] = nums[n-1];
        for (int i = n - 2; i >= 0; i--) {
            backward[i] = backward[i+1] * nums[i];
        }
        
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int prev = i == 0 ? 1 : forward[i-1];
            int next = i == n - 1 ? 1 : backward[i+1];
            result[i] = prev * next;
        }
        return result;
    }
    
    public static int[] solutionX(int[] nums) {
        int n = nums.length;
        
        int[] forward = new int[n];
        forward[0] = 1;
        for (int i = 1; i < n; i++) {
            forward[i] = forward[i-1] * nums[i-1];
        }
        
        int[] backward = new int[n];
        backward[n-1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            backward[i] = backward[i+1] * nums[i+1];
        }
        
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = forward[i] * backward[i];
        }
        return result;
    }
    
    public static int[] solutionXX(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i-1] * nums[i-1];
        }
        
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5};
        System.out.println(Arrays.toString(ProductOfArrayExceptSelf.solution(nums)));
        System.out.println(Arrays.toString(ProductOfArrayExceptSelf.solutionX(nums)));
        System.out.println(Arrays.toString(ProductOfArrayExceptSelf.solutionXX(nums)));
    }

}
