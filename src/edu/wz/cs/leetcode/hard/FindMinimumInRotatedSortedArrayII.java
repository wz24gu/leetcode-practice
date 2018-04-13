package edu.wz.cs.leetcode.hard;

/**
 * 154. Find Minimum in Rotated Sorted Array II<br/>
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii<br/><br/>
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.<br/>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).<br/>
 * 
 * Find the minimum element. The array may contain duplicates.
 */
public class FindMinimumInRotatedSortedArrayII {
    
    public static int solution(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int result = nums[0];
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid]) {
                result = Math.min(result, nums[left]);
                left = mid + 1;
            }
            else if (nums[left] > nums[mid]) {
                result = Math.min(result, nums[right]);
                right = mid;
            }
            else {
                left++;
            }
        }
        
        result = Math.min(result, Math.min(nums[left], nums[right]));
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 2};
        System.out.println(FindMinimumInRotatedSortedArrayII.solution(nums));
        
        int[] nums2 = {2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2};
        System.out.println(FindMinimumInRotatedSortedArrayII.solution(nums2));
    }

}
