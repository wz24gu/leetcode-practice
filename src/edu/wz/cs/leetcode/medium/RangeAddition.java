package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 370. Range Addition<br>
 * https://leetcode.com/problems/range-addition<br><br>
 * 
 * Assume you have an array of length n initialized with all 0's and are given k update operations. Each operation is 
 * represented as a triplet: [startIndex, endIndex, increment] which increments each element of subarray 
 * A[startIndex ... endIndex] (startIndex and endIndex inclusive) with increment. Return the modified array after all 
 * k operations were executed.<br><br>
 * 
 * Hint:<br>
 * 1. Thinking of using advanced data structures? You are thinking it too complicated.<br>
 * 2. For each update operation, do you really need to update all elements between i and j?<br>
 * 3. Update only the first and end element is sufficient.<br>
 * 4. The optimal time complexity is O(k + n) and uses O(1) extra space.
 */
public class RangeAddition {
    
    public static int[] solutionBruteForce(int length, int[][] updates) {
        int[] result = new int[length];
        if (updates == null || updates.length == 0) {
            return result;
        }
        
        for (int[] update : updates) {
            for (int i = update[0]; i <= update[1]; i++) {
                result[i] += update[2];
            }
        }
        return result;
    }
    
    public static int[] solutionX(int length, int[][] updates) {
        int[] result = new int[length];        
        if (updates == null || updates.length == 0) {
            return result;
        }
        
        int[] nums = new int[length + 1];
        for (int[] update : updates) {
            nums[update[0]] += update[2];
            nums[update[1] + 1] -= update[2];
        }
        
        result[0] = nums[0];
        for (int i = 1; i < length; i++) {
            result[i] = result[i-1] + nums[i];
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[][] updates = { {1,  3,  2},
                            {2,  4,  3},
                            {0,  2, -2} };
        System.out.println(Arrays.toString(RangeAddition.solutionBruteForce(5, updates)));
        System.out.println(Arrays.toString(RangeAddition.solutionX(5, updates)));
    }

}
