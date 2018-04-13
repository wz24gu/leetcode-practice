package edu.wz.cs.leetcode.easy;

import java.util.Arrays;

/**
 * 645. Set Mismatch<br>
 * https://leetcode.com/problems/set-mismatch<br><br>
 * 
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in 
 * the set got duplicated to another number in the set, which results in repetition of one number and loss of another 
 * number.<br>
 * 
 * Given an array nums representing the data status of this set after the error. Your task is to firstly find the 
 * number occurs twice and then find the number that is missing. Return them in the form of an array.<br><br>
 * 
 * Note:<br>
 * 1. The given array size will in the range [2, 10000].<br>
 * 2. The given array's numbers won't have any order.
 */
public class SetMismatch {
    
    public static int[] solution(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n + 1];
        for (int num : nums) {
            freq[num]++;
        }
        
        int[] result = new int[2];
        for (int i = 1; i <= n; i++) {
            if (freq[i] == 2) {
                result[0] = i;
            }
            else if (freq[i] == 0) {
                result[1] = i;
            }
        }
        return result;        
    }
    
    public static int[] solutionAlt(int[] nums) {
        int[] result = {0, 0};
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0) {
                result[0] = idx + 1;
            }
            else {
                nums[idx] *= -1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result[1] = i + 1;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        System.out.println(Arrays.toString(SetMismatch.solution(nums)));
        System.out.println(Arrays.toString(SetMismatch.solutionAlt(nums)));
    }

}
