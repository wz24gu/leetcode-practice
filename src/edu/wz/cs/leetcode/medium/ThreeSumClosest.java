package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 16. 3Sum Closest<br>
 * https://leetcode.com/problems/3sum-closest<br><br>
 * 
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 */
public class ThreeSumClosest {
    
    public static int solution(int[] nums, int target) {
        Arrays.sort(nums);
        
        int res = nums[0] + nums[1] + nums[2];
        int min = Math.abs(res - target);
        int n = nums.length;
        
        for (int i = 0; i < n - 2; i++)  {
            int lo = i + 1;
            int hi = n - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                int diff = Math.abs(sum - target);
                if (diff < min) {
                    min = diff;
                    res = sum;
                }
                
                if (sum < target) {
                    lo++;
                }
                else if (sum > target) {
                    hi--;
                }
                else {
                    break;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(ThreeSumClosest.solution(nums, 1));
    }

}
