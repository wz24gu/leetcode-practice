package edu.wz.cs.leetcode.easy;

/**
 * 303. Range Sum Query - Immutable<br>
 * https://leetcode.com/problems/range-sum-query-immutable<br><br>
 * 
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.<br><br>
 * 
 * Note:<br>
 * 1. You may assume that the array does not change.<br>
 * 2. There are many calls to sumRange function.
 */
public class RangeSumQueryImmutable {
    
    private int[] sum;
    
    public RangeSumQueryImmutable(int[] nums) {
        int n = nums.length;
        sum = new int[n+1];
        
        // rolling sum
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
    
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQueryImmutable rangeSum = new RangeSumQueryImmutable(nums);
        System.out.println(rangeSum.sumRange(0, 2));
        System.out.println(rangeSum.sumRange(2, 5));
        System.out.println(rangeSum.sumRange(0, 5));
    }

}
