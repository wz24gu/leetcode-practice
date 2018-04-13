package edu.wz.cs.leetcode.easy;

import java.util.Arrays;

/**
 * 26. Remove Duplicates from Sorted Array<br>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array<br><br>
 * 
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new
 * length.<br>
 * 
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) 
 * extra memory.<br>
 * 
 * Given nums = [1,1,2], Your function should return length = 2, with the first two elements of nums being 1 and 2 
 * respectively. It doesn't matter what you leave beyond the new length.
 * 
 */
public class RemoveDuplicatesFromSortedArray {
    
    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int i = 0;
        int j = 0;
        while (j < n) {
            if (nums[i] == nums[j]) {
                j++;
            }
            else {
                nums[++i] = nums[j++];
            }
        }
        return i + 1;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(RemoveDuplicatesFromSortedArray.solution(nums));
        System.out.println(Arrays.toString(nums));
        
        int[] nums2 = {1, 1, 1};
        System.out.println(RemoveDuplicatesFromSortedArray.solution(nums2));
        System.out.println(Arrays.toString(nums2));
    }

}
