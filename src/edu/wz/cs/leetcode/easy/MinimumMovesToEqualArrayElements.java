package edu.wz.cs.leetcode.easy;

import java.util.Arrays;

/**
 * 453. Minimum Moves To Equal Array Elements<br>
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements<br><br>
 * 
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing n - 1 elements by 1.
 */
public class MinimumMovesToEqualArrayElements {

    // add 1 to n-1 elements equals to minus 1 from 1 element
    public static int solution(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        
        int result = 0;
        for (int num : nums) {
            result += num - min;
        }
        return result;
    }
    
    public static int solutionAlt(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int num : nums) {
            result += num - nums[0];
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(MinimumMovesToEqualArrayElements.solution(nums));
        System.out.println(MinimumMovesToEqualArrayElements.solutionAlt(nums));
    }

}
