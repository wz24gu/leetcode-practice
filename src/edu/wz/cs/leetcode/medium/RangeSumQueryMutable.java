package edu.wz.cs.leetcode.medium;

/**
 * 307. Range Sum Query - Mutable<br>
 * https://leetcode.com/problems/range-sum-query-mutable<br><br>
 * 
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.<br>
 * 
 * The update(i, val) function modifies nums by updating the element at index i to val.<br><br>
 * 
 * Note:<br>
 * 1. The array is only modifiable by the update function.<br>
 * 2. You may assume the number of calls to update and sumRange function is distributed evenly.
 */
public class RangeSumQueryMutable {
    
    private int[] bit;
    private int[] nums;
    private int n;
    
    public RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
        n = nums.length;
        
        bit = new int[n+1];
        for (int i = 0; i < n; i++) {
            helper(i, nums[i]);
        }
    }
    
    private void helper(int i, int val) {
        for (int j = i + 1; j <= n; j += (j & - j)) {
            bit[j] += val;
        }
    }
    
    public void update(int i, int val) {
        int diff = val - nums[i];
        helper(i, diff);
        nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        return getSum(j + 1) - getSum(i);
    }
    
    private int getSum(int i) {
        int sum = 0;
        for (int j = i; j > 0; j -= (j & -j)) {
            sum += bit[j];
        }
        return sum;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        RangeSumQueryMutable rangeSumQueryMutable = new RangeSumQueryMutable(nums);
        System.out.println(rangeSumQueryMutable.sumRange(0, 2));
        rangeSumQueryMutable.update(1, 2);
        System.out.println(rangeSumQueryMutable.sumRange(0, 2));
    }

}
