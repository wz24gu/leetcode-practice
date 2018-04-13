package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 611. Valid Triangle Number<br>
 * https://leetcode.com/problems/valid-triangle-number<br><br>
 * 
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array 
 * that can make triangles if we take them as side lengths of a triangle.<br><br>
 * 
 * Note:<br>
 * 1. The length of the given array won't exceed 1000.<br>
 * 2. The integers in the given array are in the range of [0, 1000].
 */
public class ValidTriangleNumber {
    
    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int result = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                int left = j + 1, right = n - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (sum > nums[mid]) {
                        left = mid + 1;
                    }
                    else {
                        right = mid - 1;
                    }
                }
                result += left - 1 - j;
            }
        }
        
        return result;
    }
    
    public static int solutionX(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int result = 0;
        int n = nums.length;
        for (int i = n - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    result += right - left;
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4};
        System.out.println(ValidTriangleNumber.solution(nums));
        System.out.println(ValidTriangleNumber.solutionX(nums));
    }

}
