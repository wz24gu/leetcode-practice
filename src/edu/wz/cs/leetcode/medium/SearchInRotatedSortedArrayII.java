package edu.wz.cs.leetcode.medium;

/**
 * 81. Search in Rotated Sorted Array II<br>
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii<br><br>
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.<br>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).<br>
 * 
 * Write a function to determine if a given target is in the array.<br>
 * The array may contain duplicates.
 */
public class SearchInRotatedSortedArrayII {
    
    public static boolean solution(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return true;
            }
            
            if (nums[mid] < nums[hi]) {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                }
                else {
                    hi = mid - 1;
                }
            }
            else if (nums[mid] > nums[hi]) {
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                }
                else {
                    lo = mid + 1;
                }
            }
            else {  // duplicates
                hi--;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 1};
        System.out.println(SearchInRotatedSortedArrayII.solution(nums, 3));
    }

}
