package edu.wz.cs.leetcode.easy;

import java.util.Arrays;

/**
 * 27. Remove Element<br>
 * https://leetcode.com/problems/remove-element<br><br>
 * 
 * Given an array and a value, remove all instances of that value in place and return the new length.<br>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) 
 * extra memory.<br>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
    
    public static int solution(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == val) {
                int swap = nums[i];
                nums[i] = nums[j];
                nums[j] = swap;
                j--;
            }
            else {
                i++;
            }
        }
        
        return i;
    }
    
    public static int solutionX(int[] nums, int val) {        
        int n = nums.length;
        int i = 0;
        int j = 0;
        while (j < n) {
            if (nums[j] == val) {
                j++;
            }
            else {
                int swap = nums[j];
                nums[j] = nums[i];
                nums[i] = swap;
                i++;
                j++;
            }
        }
        
        return i;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        System.out.println(RemoveElement.solution(nums, 3));
        System.out.println(Arrays.toString(nums));
        
        int[] nums2 = {3, 2, 2, 3};
        System.out.println(RemoveElement.solutionX(nums2, 3));
        System.out.println(Arrays.toString(nums2));
    }

}
