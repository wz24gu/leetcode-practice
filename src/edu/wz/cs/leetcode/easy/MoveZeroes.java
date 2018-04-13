package edu.wz.cs.leetcode.easy;

import java.util.Arrays;

/**
 * 283. Move Zeroes<br>
 * https://leetcode.com/problems/move-zeroes<br><br>
 * 
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the 
 * non-zero elements.<br>
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].<br><br>
 * 
 * Note:<br>
 * 1. You must do this in-place without making a copy of the array.<br>
 * 2. Minimize the total number of operations.
 */
public class MoveZeroes {
    
    public static void solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int n = nums.length;
        int i = 0;
        int j = 0;
        
        while (j < n) {
            if (nums[j] == 0) {
                j++;
            }
            else {
                if (i != j) {
                    int swap = nums[j];
                    nums[j] = nums[i];
                    nums[i] = swap;
                }
                i++;
                j++;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        MoveZeroes.solution(nums);
        System.out.println(Arrays.toString(nums));
    }

}
