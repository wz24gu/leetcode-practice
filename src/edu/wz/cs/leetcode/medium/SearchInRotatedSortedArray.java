package edu.wz.cs.leetcode.medium;

/**
 * 33. Search in Rotated Sorted Array<br>
 * https://leetcode.com/problems/search-in-rotated-sorted-array<br><br>
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.<br>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).<br>
 * 
 * You are given a target value to search. If found in the array return its index, otherwise return -1.<br>
 * 
 * You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray {
    
    public static int solution(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < nums[hi]) {  // right part is ASC
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                }
                else {
                    hi = mid - 1;
                }
            }
            else {  // left part is ASC
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                }
                else {
                    lo = mid + 1;
                }
            }            
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println(SearchInRotatedSortedArray.solution(nums, 6));
        System.out.println(SearchInRotatedSortedArray.solution(nums, 2));
    }

}
