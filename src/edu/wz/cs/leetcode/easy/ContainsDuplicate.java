package edu.wz.cs.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate<br>
 * https://leetcode.com/problems/contains-duplicate<br><br>
 * 
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value 
 * appears at least twice in the array, and it should return false if every element is distinct.
 */
public class ContainsDuplicate {

    public static boolean solution(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean solutionAlt(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 5, 2, 4, 2};
        System.out.println(ContainsDuplicate.solution(nums));
        System.out.println(ContainsDuplicate.solutionAlt(nums));
    }
    
}
