package edu.wz.cs.leetcode.easy;

/**
 * 136. Single Number<br>
 * https://leetcode.com/problems/single-number<br><br>
 * 
 * Given an array of integers, every element appears twice except for one. Find that single one.<br>
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {
    
    public static int solution(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 2, 5, 1, 4};
        System.out.println(SingleNumber.solution(nums));
    }

}
