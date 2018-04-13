package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 324. Wiggle Sort II<br>
 * https://leetcode.com/problems/wiggle-sort-ii<br><br>
 * 
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....<br>
 * 
 * Example:<br>
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].<br>
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].<br>
 * 
 * Note:<br>
 * You may assume all input has valid answer.<br>
 * 
 * Follow Up:<br>
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class WiggleSortII {
    
    public static void solution(int[] nums) {
        int n = nums.length;
        int mid = (n + 1) / 2;
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);
        
        for (int i = mid - 1, j = 0; i >= 0; i--, j += 2) {
            nums[j] = copy[i];
        }
        for (int i = n - 1, j = 1; i >= mid; i--, j += 2) {
            nums[j] = copy[i];
        }
    }
    
    // TODO: implement by using partition
    
    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        WiggleSortII.solution(nums);
        System.out.println(Arrays.toString(nums));
        
        int[] nums2 = {1, 3, 2, 2, 3, 1};
        WiggleSortII.solution(nums2);
        System.out.println(Arrays.toString(nums2));
    }

}
