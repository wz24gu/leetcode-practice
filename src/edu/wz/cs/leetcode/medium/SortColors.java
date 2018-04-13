package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 75. Sort Colors<br>
 * https://leetcode.com/problems/sort-colors<br><br>
 * 
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.<br>
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.<br>
 * 
 * Note: You are not suppose to use the library's sort function for this problem.
 */
public class SortColors {
    
    public static void solution(int[] nums) {
        int[] index = new int[3];
        for (int num : nums) {
            index[num]++;
        }
        
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < index[i]; j++) {
                nums[k++] = i;
            }
        }        
    }
    
    public static void solutionX(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        int i = 0;
        while (i <= blue) {
            if (nums[i] == 0) {
                swap(nums, i++, red++);
            }
            else if (nums[i] == 2) {
                swap(nums, i, blue--);
            }
            else {
                i++;
            }
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 1, 0, 1, 1, 2, 2};
        SortColors.solution(nums);
        System.out.println(Arrays.toString(nums));
        
        int[] nums2 = {1, 0, 2, 1, 0, 1, 1, 2, 2};
        SortColors.solutionX(nums2);
        System.out.println(Arrays.toString(nums2));
    }

}
