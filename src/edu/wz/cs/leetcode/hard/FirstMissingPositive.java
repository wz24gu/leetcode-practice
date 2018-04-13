package edu.wz.cs.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * 41. First Missing Positive<br>
 * https://leetcode.com/problems/first-missing-positive<br><br>
 * 
 * Given an unsorted integer array, find the first missing positive integer.<br>
 * 
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.<br>
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive {
    
    public static int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            set.add(num);
            max = Math.max(max, num);
        }
        
        for (int i = 1; i <= max; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return max + 1;
    }
    
    public static int solutionX(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] != i + 1 && nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i] - 1);
            }
            else {
                i++;
            }            
        }
        
        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return n + 1;
    }
    
    private static void swap(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        System.out.println(FirstMissingPositive.solution(nums));
        System.out.println(FirstMissingPositive.solutionX(nums));
        
        int[] nums2 = {3, 4, -1, 1};
        System.out.println(FirstMissingPositive.solution(nums2));
        System.out.println(FirstMissingPositive.solutionX(nums2));
    }

}
