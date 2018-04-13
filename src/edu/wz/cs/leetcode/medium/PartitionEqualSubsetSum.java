package edu.wz.cs.leetcode.medium;

/**
 * 416. Partition Equal Subset Sum<br>
 * https://leetcode.com/problems/partition-equal-subset-sum<br><br>
 * 
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets 
 * such that the sum of elements in both subsets is equal.<br><br>
 * 
 * Note:<br>
 * 1. Each of the array element will not exceed 100.<br>
 * 2. The array size will not exceed 200.
 */
public class PartitionEqualSubsetSum {
    
    public static boolean solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        
        return dp[target];
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(PartitionEqualSubsetSum.solution(nums));
        
        int[] nums2 = {1, 2, 3, 5};
        System.out.println(PartitionEqualSubsetSum.solution(nums2));
    }
    
}
