package edu.wz.cs.leetcode.algorithm;

import java.util.Arrays;

/**
 * Remove Duplicated From Sorted Array (with K times allowed)
 */
public class RemoveDuplicatesFromSortedArray {
    
    public int removeX(int[] nums, int k) {
        int n = nums.length;
        if (k >= n) {
            return n;
        }
        
        int i = 0;
        for (int num : nums) {
            if (i < k || num > nums[i-k]) {
                nums[i++] = num;
            }
        }
        return i;
    }
    
    public int remove(int[] nums, int k) {
        int n = nums.length;
        if (k >= n) {
            return n;
        }
        
        int count = 1;
        int i = 0;
        int j = 1;
        while (j < n) {
            if (nums[j] == nums[j-1]) {
                if (count == k) {
                    j++;
                }
                else {
                    count++;
                    nums[++i] = nums[j++];
                }
            }
            else {
                count = 1;
                nums[++i] = nums[j++];
            }
        }
        return i + 1;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
        System.out.println(r.removeX(nums, 1));
        System.out.println(Arrays.toString(nums));
        
        int[] nums2 = {1, 1, 1, 2, 2, 3};        
        System.out.println(r.remove(nums2, 1));
        System.out.println(Arrays.toString(nums2));
    }

}
