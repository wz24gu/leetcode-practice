package edu.wz.cs.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 548. Split Array with Equal Sum<br>
 * https://leetcode.com/problems/split-array-with-equal-sum<br><br>
 * 
 * Given an array with n integers, you need to find if there are triplets (i, j, k) which satisfies following conditions:<br>
 * 1. 0 < i, i + 1 < j, j + 1 < k < n - 1<br>
 * 2. Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.<br>
 * 
 * Where we define that subarray (L, R) represents a slice of the original array starting from the element indexed L to 
 * the element indexed R.<br><br>
 * 
 * Note:<br>
 * 1. 1 <= n <= 2000.<br>
 * 2. Elements in the given array will be in range [-1,000,000, 1,000,000].
 */
public class SplitArrayWithEqualSum {
    
    public static boolean solutionX(int[] nums) {
        if (nums.length < 7) {
            return false;
        }
        
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        
        for (int j = 3; j < n - 3; j++) {
            Set<Integer> set = new HashSet<>();
            // left side
            for (int i = 1; i < j - 1; i++) {
                if (sum[i-1] == sum[j-1] - sum[i]) {
                    set.add(sum[i-1]);
                }
            }
            // right side
            for (int k = j + 2; k < n - 1; k++) {
                if (sum[k-1] - sum[j] == sum[n-1] - sum[k]) {
                    if (set.contains(sum[k-1] - sum[j])) {
                        return true;
                    }
                }
            }            
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 1, 2, 1};
        System.out.println(SplitArrayWithEqualSum.solutionX(nums));
    }

}
