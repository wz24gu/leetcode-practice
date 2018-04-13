package edu.wz.cs.leetcode.hard;

import java.util.Arrays;

/**
 * 164. Maximum Gap<br>
 * https://leetcode.com/problems/maximum-gap<br><br>
 * 
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.<br>
 * 
 * Try to solve it in linear time/space.<br>
 * 
 * Return 0 if the array contains less than 2 elements.<br>
 * 
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
public class MaximumGap {
    
    public static int solution(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        // get the max and min value
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        if (max == min) {
            return 0;
        }
        
        // minimum gap
        int n = nums.length;
        int gap = (int) Math.ceil((double) (max - min) / (n - 1));
        int[] bucketMin = new int[n];
        int[] bucketMax = new int[n];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        
        // fill in the bucket, we only fill in the min and max
        for (int num : nums) {
            int idx = (num - min) / gap;
            bucketMin[idx] = Math.min(bucketMin[idx], num);
            bucketMax[idx] = Math.max(bucketMax[idx], num);
        }
        
        int prev = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (bucketMin[i] != Integer.MAX_VALUE) {  // ignore the empty bucket
                result = Math.max(result, bucketMin[i] - prev);
                prev = bucketMax[i];
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 1, 0, 9, 7, 20, 5, 18};
        System.out.println(MaximumGap.solution(nums));
    }

}
