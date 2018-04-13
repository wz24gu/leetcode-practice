package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 462. Minimum Moves to Equal Array Elements II<br>
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii<br><br>
 * 
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a 
 * move is incrementing a selected element by 1 or decrementing a selected element by 1.<br>
 * 
 * You may assume the array's length is at most 10,000.
 */
public class MinimumMovesToEqualArrayElementsII {
    
    public static int solution(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int result = 0;
        int mid = nums[nums.length / 2];
        for (int num : nums) {
            result += Math.abs(mid - num);  // absolute value
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(MinimumMovesToEqualArrayElementsII.solution(nums));
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(MinimumMovesToEqualArrayElementsII.solution(nums1));
    }

}
