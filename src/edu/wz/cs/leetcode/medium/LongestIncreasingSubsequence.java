package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 300. Longest Increasing Subsequence<br>
 * https://leetcode.com/problems/longest-increasing-subsequence<br><br>
 * 
 * Given an unsorted array of integers, find the length of longest increasing subsequence.<br>
 * 
 * For example, Given [10, 9, 2, 5, 3, 7, 101, 18],<br>
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one 
 * LIS combination, it is only necessary for you to return the length.<br>
 * 
 * Your algorithm should run in O(n^2) complexity.<br>
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {
    
    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }        
        
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }            
        }
        
        return max;   
    }
    
    public static int solutionBinarySearch(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int lo = 0;
            int hi = list.size() - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) /2;
                if (list.get(mid) < nums[i]) {
                    lo = mid + 1;
                }
                else {
                    hi = mid - 1;
                }
            }
            
            if (lo >= list.size()) {
                list.add(nums[i]);
            }
            else {
                list.set(lo, nums[i]);
            }
        }
        
        return list.size();
    }
    
    /**
     * https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824
     */
    public static int solutionX(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int size = 0;
        int[] tails = new int[n];
        for (int x : nums) {
            int i = 0;
            int j = size;
            while (i != j) {
                int m = i + (j - i) / 2;
                if (tails[m] < x) {
                    i = m + 1;
                }
                else {
                    j = m;
                }
            }
            tails[i] = x;
            if (i == size) {
                size++;
            }
        }
        
        return size;    
    }
    
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(LongestIncreasingSubsequence.solution(nums));
        System.out.println(LongestIncreasingSubsequence.solutionBinarySearch(nums));
        System.out.println(LongestIncreasingSubsequence.solutionX(nums));
    }

}
