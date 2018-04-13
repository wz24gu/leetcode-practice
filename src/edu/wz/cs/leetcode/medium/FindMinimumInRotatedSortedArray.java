package edu.wz.cs.leetcode.medium;

/**
 * 153. Find Minimum in Rotated Sorted Array<br>
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array<br><br>
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.<br>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).<br>
 * 
 * Find the minimum element.<br>
 * 
 * You may assume no duplicate exists in the array.
 */
public class FindMinimumInRotatedSortedArray {
    
    public static int solution(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        if (nums[lo] < nums[hi]) {
            return nums[lo];
        }
        
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[lo] < nums[mid]) {
                lo = mid;
            }
            else {
                hi = mid;
            }
        }
        return Math.min(nums[lo], nums[hi]);
    }
    
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(FindMinimumInRotatedSortedArray.solution(nums));
        
        int[] nums2 = {1};
        System.out.println(FindMinimumInRotatedSortedArray.solution(nums2));
    }

}
