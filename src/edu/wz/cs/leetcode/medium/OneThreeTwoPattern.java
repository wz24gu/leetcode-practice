package edu.wz.cs.leetcode.medium;

import java.util.Stack;

/**
 * 456. 132 Pattern<br>
 * https://leetcode.com/problems/132-pattern<br><br>
 * 
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and 
 * ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern 
 * in the list.<br>
 * 
 * Note: n will be less than 15,000.
 */
public class OneThreeTwoPattern {
    
    public static boolean solution(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return false;
        }
        
        int n = nums.length;
        int i = 0;
        int j = 0;
        int k = 0;
        
        while (i < n) {
            while (i < n - 1 && nums[i] >= nums[i+1]) {
                i++;
            }
            j = i + 1;
            while (j < n - 1 && nums[j] <= nums[j+1]) {
                j++;
            }
            k = j + 1;
            while (k < n) {
                if (nums[k] > nums[i] && nums[k] < nums[j]) {
                    return true;
                }
                k++;
            }
            i = j + 1;
        }
        
        return false;
    }
    
    public static boolean solutionX(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return false;
        }
        
        int two = Integer.MIN_VALUE;
        Stack<Integer> three = new Stack<>();
        
        int n = nums.length;
        for (int i =  n - 1; i >= 0; i--) {
            if (nums[i] < two) {
                return true;
            }
            else {
                while (!three.isEmpty() && nums[i] > three.peek()) {
                    two = three.pop();
                }
            }
            three.push(nums[i]);
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(OneThreeTwoPattern.solution(nums));
        System.out.println(OneThreeTwoPattern.solutionX(nums));
        
        int[] nums2 = {3, 1, 4, 2};
        System.out.println(OneThreeTwoPattern.solution(nums2));
        System.out.println(OneThreeTwoPattern.solutionX(nums2));
        
        int[] nums3 = {-1, 3, 2, 0};
        System.out.println(OneThreeTwoPattern.solution(nums3));
        System.out.println(OneThreeTwoPattern.solutionX(nums3));
    }

}
