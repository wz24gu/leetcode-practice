package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 473. Matchsticks to Square<br>
 * https://leetcode.com/problems/matchsticks-to-square<br><br>
 * 
 * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please 
 * find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can 
 * link them up, and each matchstick must be used exactly one time.<br>
 * 
 * Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be 
 * true or false, to represent whether you could make one square using all the matchsticks the little match girl has.<br><br>
 * 
 * Note:<br>
 * 1. The length sum of the given matchsticks is in the range of 0 to 10^9.<br>
 * 2. The length of the given matchstick array will not exceed 15.
 */
public class MatchsticksToSquare {
    
    public static boolean solution(int[] nums) {
        if (nums == null || nums.length < 4) {
            return false;
        }
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        
        Arrays.sort(nums);
        reverse(nums);
        return dfs(nums, new int[4], 0, sum / 4);
    }
    
    private static boolean dfs(int[] nums, int[] sum, int index, int target) {
        if (index == nums.length) {
            if (sum[0] == target && sum[1] == target && sum[2] == target) {
                return true;
            }
            return false;
        }
        
        for (int i = 0; i < 4; i++) {
            if (sum[i] + nums[index] > target) {
                continue;
            }
            
            sum[i] += nums[index];
            if (dfs(nums, sum, index + 1, target)) {
                return true;
            }
            sum[i] -= nums[index];
        }
        
        return false;
    }
    
    private static void reverse(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int swap = nums[i];
            nums[i] = nums[j];
            nums[j] = swap;
            i++;
            j--;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2};
        System.out.println(MatchsticksToSquare.solution(nums));
        
        int[] nums2 = {3, 3, 3, 3, 4};
        System.out.println(MatchsticksToSquare.solution(nums2));
    }

}
