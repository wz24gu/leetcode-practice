package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 325. Maximum Size Subarray Sum Equals K<br>
 * https://leetcode.com/problems/maximum-size-subarray-sum-equals-k<br><br>
 * 
 * Given an array nums and a target value k, find the maximum length of a subarray (continuous) that sums to k. If 
 * there isn't one, return 0 instead.<br>
 * 
 * Follow Up: can you do it in O(n) time?
 */
public class MaximumSizeSubarraySumEqualsK {

    public static int solution(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int result = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                result = Math.max(result, i + 1);
            }
            if (map.containsKey(sum - k)) {
                result = Math.max(result, i - map.get(sum - k));
            }
            
            if (!map.containsKey(sum)) {
                map.put(sum, i);  // always keep the first i for the longest subarray
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        System.out.println(MaximumSizeSubarraySumEqualsK.solution(nums, 3));
        
        int[] nums1 = {-2, -1, 2, 1};
        System.out.println(MaximumSizeSubarraySumEqualsK.solution(nums1, 1));
    }

}
