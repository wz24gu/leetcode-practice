package edu.wz.cs.leetcode.medium;

/**
 * 377. Combination Sum IV<br>
 * https://leetcode.com/problems/combination-sum-iv<br><br>
 * 
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that 
 * add up to a positive integer target.<br><br>
 * 
 * Follow up:<br>
 * 1. What if negative numbers are allowed in the given array?<br>
 * 2. How does it change the problem?<br>
 * 3. What limitation we need to add to the question to allow negative numbers?
 */
public class CombinationSumIV {
    
    // this solution is TLE
    public static int solution(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                result += solution(nums, target - nums[i]);
            }
        }
        return result;
    }
    
    public static int solutionDP(int[] nums, int target) {        
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(CombinationSumIV.solution(nums, 4));
        System.out.println(CombinationSumIV.solutionDP(nums, 4));
    }

}
