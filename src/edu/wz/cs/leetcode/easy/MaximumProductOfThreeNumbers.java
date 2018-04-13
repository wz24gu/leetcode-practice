package edu.wz.cs.leetcode.easy;

import java.util.Arrays;

/**
 * 628: Maximum Product of Three Numbers<br>
 * https://leetcode.com/problems/maximum-product-of-three-numbers<br><br>
 * 
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.<br><br>
 * 
 * Note:<br>
 * 1. The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].<br>
 * 2. Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer
 */
public class MaximumProductOfThreeNumbers {
    
    public static int solution(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n-1], nums[n-1] * nums[n-2] * nums[n-3]);
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(MaximumProductOfThreeNumbers.solution(nums));
        
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(MaximumProductOfThreeNumbers.solution(nums2));
    }

}
