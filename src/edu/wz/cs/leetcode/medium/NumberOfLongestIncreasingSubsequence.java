package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 673. Number of Longest Increasing Subsequence<br>
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence<br><br>
 * 
 * Given an unsorted array of integers, find the number of longest increasing subsequence.<br>
 * 
 * Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
 */
public class NumberOfLongestIncreasingSubsequence {
    
    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int[] len = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(len, 1);
        Arrays.fill(cnt, 1);        
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] == len[j] + 1) {
                        cnt[i] += cnt[j];
                    }
                    else if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
        }
        
        int max = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, len[i]);
        }
        for (int i = 0; i < n; i++) {
            if (len[i] == max) {
                res += cnt[i];
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        System.out.println(NumberOfLongestIncreasingSubsequence.solution(nums));
        
        int[] nums2 = {2, 2, 2, 2, 2};
        System.out.println(NumberOfLongestIncreasingSubsequence.solution(nums2));
    }

}
