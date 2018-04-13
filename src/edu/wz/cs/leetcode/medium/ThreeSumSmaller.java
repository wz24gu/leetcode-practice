package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 259. 3Sum Smaller<br>
 * https://leetcode.com/problems/3sum-smaller<br><br>
 * 
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n 
 * that satisfy the condition nums[i] + nums[j] + nums[k] < target.<br>
 * 
 * For example, given nums = [-2, 0, 1, 3], and target = 2. Return 2.<br>
 * Because there are two triplets which sums are less than 2:
 * [-2, 0, 1], [-2, 0, 3]<br>
 * 
 * Follow up: Could you solve it in O(n2) runtime?
 */
public class ThreeSumSmaller {
    
    public static int solutionBruteForce(int[] nums, int target) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        
        int result = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] < target) {
                        result++;
                    }
                }
            }
        }
        
        return result;
    }
    
    public static int solutionX(int[] nums, int target) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int result = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    result += right - left;
                    left++;
                }
                else {
                    right--;
                }
            }            
        }
        
        return result;
        
    }
    
    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};
        System.out.println(ThreeSumSmaller.solutionBruteForce(nums, 2));
        System.out.println(ThreeSumSmaller.solutionX(nums, 2));
    }

}
