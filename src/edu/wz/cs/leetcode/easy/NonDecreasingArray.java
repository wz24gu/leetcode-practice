package edu.wz.cs.leetcode.easy;

/**
 * 665. Non-decreasing Array<br>
 * https://leetcode.com/problems/non-decreasing-array<br><br>
 * 
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.<br>
 * 
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).<br>
 * 
 * Note: The n belongs to [1, 10,000].
 */
public class NonDecreasingArray {
    
    public static boolean solution(int[] nums) {        
        int count = 0;
        
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i-1]) {
                count++;
                
                if (i == 1 || nums[i] >= nums[i-2]) {  // tricky comparison
                    nums[i-1] = nums[i];
                }
                else {
                    nums[i] = nums[i-1];
                }
            }
        }
        return count <= 1;
    }
    
    public static void main(String[] args) {
        int[] nums = {4, 2, 3};
        System.out.println(NonDecreasingArray.solution(nums));
        
        int[] nums2 = {4, 2, 1};
        System.out.println(NonDecreasingArray.solution(nums2));
    }

}
