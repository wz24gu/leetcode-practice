package edu.wz.cs.leetcode.easy;

/**
 * 747. Largest Number At Least Twice of Others<br>
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others<br><br>
 * 
 * In a given integer array nums, there is always exactly one largest element.<br>
 * 
 * Find whether the largest element in the array is at least twice as much as every other number in the array.<br>
 * 
 * If it is, return the index of the largest element, otherwise return -1.<br><br>
 * 
 * Note:<br>
 * 1. nums will have a length in the range [1, 50].<br>
 * 2. Every nums[i] will be an integer in the range [0, 99].
 */
public class LargestNumberAtLeastTwiceOfOthers {
    
    public static int solution(int[] nums) {
        int n = nums.length;
        
        int[] max1 = {-1, -1};
        int[] max2 = {-1, -1};
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > max1[0]) {
                max2 = max1;
                max1 = new int[] {nums[i], i};
            }
            else if (max1[0] > nums[i] && nums[i] > max2[0]) {
                max2 = new int[] {nums[i], i};
            }
        }
        
        if (max1[0] >= max2[0] * 2) {
            return max1[1];
        }
        else {
            return -1;
        }        
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 6, 1, 0};
        System.out.println(LargestNumberAtLeastTwiceOfOthers.solution(nums));
        
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(LargestNumberAtLeastTwiceOfOthers.solution(nums2));
        
        int[] nums3 = {0, 0, 0, 1};
        System.out.println(LargestNumberAtLeastTwiceOfOthers.solution(nums3));
    }

}
