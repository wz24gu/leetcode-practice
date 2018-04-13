package edu.wz.cs.leetcode.medium;

/**
 * 740. Delete and Earn<br>
 * https://leetcode.com/problems/delete-and-earn<br><br>
 * 
 * Given an array nums of integers, you can perform operations on the array.<br>
 * 
 * In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element 
 * equal to nums[i] - 1 or nums[i] + 1.<br>
 * 
 * You start with 0 points. Return the maximum number of points you can earn by applying such operations.<br><br>
 * 
 * Note:<br>
 * 1. The length of nums is at most 20000.<br>
 * 2. Each element nums[i] is an integer in the range [1, 10000].
 */
public class DeleteAndEarn {
    
    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = 10001;
        int[] values = new int[n];
        for (int num : nums) {
            values[num] += num;
        }
        
        int take = 0;
        int skip = 0;
        for (int i = 0; i < n; i++) {
            int take_i = skip + values[i];
            int skip_i = Math.max(skip, take);
            take = take_i;
            skip = skip_i;
        }
        return Math.max(take, skip);        
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 4, 2};
        System.out.println(DeleteAndEarn.solution(nums));
        
        int[] nums2 = {2, 2, 3, 3, 3, 4};
        System.out.println(DeleteAndEarn.solution(nums2));
    }

}
