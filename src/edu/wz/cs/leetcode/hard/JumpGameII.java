package edu.wz.cs.leetcode.hard;

/**
 * 45. Jump Game II<br>
 * https://leetcode.com/problems/jump-game-ii<br><br>
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.<br>
 * 
 * Each element in the array represents your maximum jump length at that position.<br>
 * 
 * Your goal is to reach the last index in the minimum number of jumps.<br>
 * 
 * For example: Given array A = [2,3,1,1,4]<br>
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)<br>
 * 
 * Note: You can assume that you can always reach the last index.
 */
public class JumpGameII {
    
    public static int solution(int[] nums) {
        int n = nums.length;
        int result = 0;
        int i = 0;
        int curr = 0;
        
        while (curr < n - 1) {
            int prev = curr;
            while (i <= prev) {
                curr = Math.max(curr, nums[i] + i);
                i++;
            }
            result++;
            if (prev == curr) {
                return -1;  // cannot reach the end
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(JumpGameII.solution(nums));
    }

}
