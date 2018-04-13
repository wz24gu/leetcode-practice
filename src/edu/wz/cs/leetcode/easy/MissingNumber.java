package edu.wz.cs.leetcode.easy;

/**
 * 268. Missing Number<br>
 * https://leetcode.com/problems/missing-number<br><br>
 * 
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.<br>
 * 
 * Note: Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space 
 * complexity?
 */
public class MissingNumber {
    
    public static int solution(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
    
    public static int solutionAlt(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            result ^= i;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(MissingNumber.solution(nums));
        System.out.println(MissingNumber.solutionAlt(nums));
        
        int[] nums2 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(MissingNumber.solution(nums2));
        System.out.println(MissingNumber.solutionAlt(nums2));
    }

}
