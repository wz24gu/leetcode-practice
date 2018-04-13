package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 31. Next Permutation<br>
 * https://leetcode.com/problems/next-permutation<br><br>
 * 
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.<br>
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).<br>
 * 
 * The replacement must be in-place, do not allocate extra memory.
 */
public class NextPermutation {
    
    public static void solution(int[] nums) {
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i+1] > nums[i]) {
                for (int j = n - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        exchange(nums, i, j);
                        reverse(nums, i + 1, n - 1);
                        return;
                    }
                }
            }
        }
        reverse(nums, 0, n - 1);
    }
    
    public static void solutionAlt(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        int j = n - 1;
        
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if (i >= 0) {
            while (nums[j] <= nums[i]) {
                j--;
            }
            if (j >= 0) {
                exchange(nums, i, j);
            }
        }
        reverse(nums, i + 1, n - 1);
    }
    
    private static void exchange(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }
    
    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            exchange(nums, i++, j--);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        NextPermutation.solution(nums);
        System.out.println(Arrays.toString(nums));
        
        int[] nums2 = {3, 2, 1};
        NextPermutation.solutionAlt(nums2);
        System.out.println(Arrays.toString(nums2));
        
        int[] nums3 = {1, 1, 5};
        NextPermutation.solutionAlt(nums3);
        System.out.println(Arrays.toString(nums3));
    }

}
