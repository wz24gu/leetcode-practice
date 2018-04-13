package edu.wz.cs.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 260. Single Number III<br>
 * https://leetcode.com/problems/single-number-iii<br><br>
 * 
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear 
 * exactly twice. Find the two elements that appear only once.<br>
 * 
 * For example: Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].<br><br>
 * 
 * Note:<br>
 * 1. The order of the result is not important. So in the above example, [5, 3] is also correct.<br>
 * 2. Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class SingleNumberIII {
    
    public static int[] solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                set.remove(n);
            }
            else {
                set.add(n);
            }
        }
        
        int[] result = new int[2];
        int i = 0;
        for (int n : set) {
            result[i++] = n;
        }
        return result;
    }
    
    public static int[] solutionX(int[] nums) {
        int diff = 0;
        for (int n : nums) {
            diff ^= n;  // diff is the XOR of two results
        }
        
        diff &= -diff;  // diff is the right most 1
        
        int[] result = new int[2];
        for (int n : nums) {
            if ((n & diff) == 0) {
                result[0] ^= n;
            }
            else {
                result[1] ^= n;
            }
        }
        return result;    
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(SingleNumberIII.solution(nums)));
        System.out.println(Arrays.toString(SingleNumberIII.solutionX(nums)));
    }

}
