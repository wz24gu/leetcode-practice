package edu.wz.cs.leetcode.medium;

/**
 * 698. Partition to K Equal Sum Subsets<br>
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets<br><br>
 * 
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k 
 * non-empty subsets whose sums are all equal.<br><br>
 * 
 * Note:
 * 1. 1 <= k <= len(nums) <= 16.<br>
 * 2. 0 < nums[i] < 10000.
 */
public class PartitionToKEqualSumSubsets {

    public static boolean solution(int[] nums, int k) {        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        
        int n = nums.length;
        boolean[] visited = new boolean[n];
        return helper(nums, 0, 0, sum / k, k, visited);
    }
    
    private static boolean helper(int[] nums, int pos, int current, int target, int k, boolean[] visited) {
        if (k == 1) {
            return true;
        }
        if (current == target) {
            return helper(nums, 0, 0, target, k-1, visited);
        }
        
        for (int i = pos; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            if (helper(nums, i + 1, current + nums[i], target, k, visited)) {
                return true;
            }
            visited[i] = false;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        System.out.println(PartitionToKEqualSumSubsets.solution(nums, 4));
    }

}
