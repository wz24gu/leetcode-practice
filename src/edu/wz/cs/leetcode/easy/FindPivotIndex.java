package edu.wz.cs.leetcode.easy;

/**
 * 724. Find Pivot Index<br>
 * https://leetcode.com/problems/find-pivot-index<br><br>
 * 
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.<br>
 * 
 * We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of 
 * the numbers to the right of the index.<br>
 * 
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most 
 * pivot index.<br><br>
 * 
 * Note:<br>
 * 1. The length of nums will be in the range [0, 10000].<br>
 * 2. Each element nums[i] will be an integer in the range [-1000, 1000].
 */
public class FindPivotIndex {
    
    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        
        for (int i = 0; i < n - 1; i++) {
            int before = (i == 0) ? 0 : sum[i-1];
            int after = (i == n - 1) ? 0 : sum[n-1] - sum[i];
            if (before == after) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(FindPivotIndex.solution(nums));
        
        int[] nums2 = {1, 2, 3};
        System.out.println(FindPivotIndex.solution(nums2));
        
        int[] nums3 = {-1, 0, -1, -1, 1, 1};
        System.out.println(FindPivotIndex.solution(nums3));
    }

}
