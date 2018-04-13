package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 523. Continuous Subarray Sum<br>
 * https://leetcode.com/problems/continuous-subarray-sum<br><br>
 * 
 * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous 
 * subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.<br><br>
 * 
 * Note:<br>
 * 1. The length of the array won't exceed 10,000.<br>
 * 2. You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 */
public class ContinuousSubarraySum {
    
    public static boolean solution(int[] nums, int k) {
        int n = nums.length;        
        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    return true;
                }
                if (k != 0 && sum % k == 0) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static boolean solutionX(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int pre = 0;
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int mod = (k == 0) ? sum : sum % k;
            if (set.contains(mod)) {
                return true;
            }
            set.add(pre);
            pre = mod;
        }
        
        return false;
    }
    
    public static boolean solutionX2(int nums[], int k) {
        int n = nums.length;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,  -1);
        
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int mod = (k == 0) ? sum : sum % k;
            if (map.containsKey(mod)) {
                if (i - map.get(mod) > 1) {
                    return true;
                }
            }
            else {
                map.put(mod, i);
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 7};
        System.out.println(ContinuousSubarraySum.solution(nums, 6));
        System.out.println(ContinuousSubarraySum.solutionX(nums, 6));
        System.out.println(ContinuousSubarraySum.solutionX2(nums, 6));
        
        int[] nums2 = {23, 2, 6, 4, 7};
        System.out.println(ContinuousSubarraySum.solution(nums2, 6));
        System.out.println(ContinuousSubarraySum.solutionX(nums2, 6));
        System.out.println(ContinuousSubarraySum.solutionX2(nums2, 6));
    }

}
