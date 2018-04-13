package edu.wz.cs.leetcode.easy;

import java.util.Arrays;

/**
 * 561. Array Partition I<br/>
 * 
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2),
 * ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.<br/><br/>
 * 
 * Note:<br/>
 * 1. n is a positive integer, which is in the range of [1, 10000].
 * 2. All the integers in the array will be in the range of [-10000, 10000].
 */
public class ArrayPartitionI {
    
    public static int solution(int[] nums) {
        Arrays.sort(nums);
        
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        System.out.println(ArrayPartitionI.solution(nums));
    }

}
