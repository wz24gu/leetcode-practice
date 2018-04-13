package edu.wz.cs.leetcode.easy;

import java.util.Arrays;

/**
 * 581. Shortest Unsorted Continuous Subarray<br>
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray<br><br>
 * 
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending 
 * order, then the whole array will be sorted in ascending order, too.<br>
 * 
 * You need to find the shortest such subarray and output its length.<br><br>
 * 
 * Note:<br>
 * 1. The length of the input array is in range [1, 10,000].<br>
 * 2. The input array may contain duplicates, so ascending order here means <=.
 */
public class ShortestUnsortedContinuousSubarray {
    
    public static int solution(int[] nums) {
        int n = nums.length;
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = nums[i];
        }
        Arrays.sort(sorted);
        
        int i = 0;
        int j = n - 1;
        while (i < n && nums[i] == sorted[i]) {
            i++;
        }
        if (i == n) {
            return 0;
        }
        
        while (j >= 0 && nums[j] == sorted[j]) {
            j--;
        }
        return j - i + 1;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(ShortestUnsortedContinuousSubarray.solution(nums));
    }

}
