package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum<br>
 * https://leetcode.com/problems/3sum<br><br>
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in 
 * the array which gives the sum of zero.<br>
 * 
 * Note: The solution set must not contain duplicate triplets.
 */
public class ThreeSum {
    
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        
        Arrays.sort(nums);
        int n = nums.length;
        
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }            
            
            int lo = i + 1;
            int hi = n - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum < 0) {
                    lo++;
                }
                else if (sum > 0) {
                    hi--;
                }
                else {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[lo+1]) {
                        lo++;
                    }
                    while (lo < hi && nums[hi] == nums[hi-1]) {
                        hi--;
                    }
                    lo++;
                    hi--;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(ThreeSum.solution(nums));
    }

}
