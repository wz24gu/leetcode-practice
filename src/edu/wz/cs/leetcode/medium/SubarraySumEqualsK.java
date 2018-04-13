package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K<br>
 * https://leetcode.com/problems/subarray-sum-equals-k<br><br>
 * 
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum 
 * equals to k.<br>
 * 
 * Example 1: Input:nums = [1,1,1], k = 2; Output: 2<br>
 * 
 * Note:<br>
 * 1. The length of the array is in range [1, 20,000].<br>
 * 2. The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class SubarraySumEqualsK {
    
    public static int solution(int[] nums, int k) {
        int n = nums.length;
        
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (sum[i] == k) {
                count++;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (sum[i] - sum[j] == k) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public static int solutionX(int[] nums, int k) {
        int count = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(SubarraySumEqualsK.solution(nums, 2));
        System.out.println(SubarraySumEqualsK.solutionX(nums, 2));
    }

}
