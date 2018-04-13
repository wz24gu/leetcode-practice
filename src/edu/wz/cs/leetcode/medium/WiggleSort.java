package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 280. Wiggle Sort<br>
 * https://leetcode.com/problems/wiggle-sort<br><br>
 * 
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....<br>
 * 
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */
public class WiggleSort {
    
    public static int[] solution(int[] nums) {
        int[] result = new int[nums.length];
        
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        for (int k = 0; k < result.length; k++) {
            if (k % 2 == 0) {
                result[k] = nums[i++];
            }
            else {
                result[k] = nums[j--];
            }
        }
        
        return result;        
    }
    
    public static int[] solutionAlt(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        
        Arrays.sort(nums);
        
        int n = nums.length;
        for (int i = 1; i < n - 1; i += 2) {
            int swap = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = swap;
        }
        
        return nums;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 6, 4};
        System.out.println(Arrays.toString(WiggleSort.solution(nums)));
        System.out.println(Arrays.toString(WiggleSort.solutionAlt(nums)));
    }

}
