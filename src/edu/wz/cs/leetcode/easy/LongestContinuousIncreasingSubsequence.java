package edu.wz.cs.leetcode.easy;

/**
 * 674. Longest Continuous Increasing Subsequence<br>
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence<br><br>
 * 
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence.<br>
 * 
 * Note: Length of the array will not exceed 10,000.
 */
public class LongestContinuousIncreasingSubsequence {

    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                count++;
            }
            else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        return Math.max(max, count);  // be careful
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        System.out.println(LongestContinuousIncreasingSubsequence.solution(nums));
        
        int[] nums2 = {2, 2, 2, 2, 2};
        System.out.println(LongestContinuousIncreasingSubsequence.solution(nums2));
    }

}
