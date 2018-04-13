package edu.wz.cs.leetcode.hard;

import java.util.Arrays;

/**
 * 719. Find K-th Smallest Pair Distance<br>
 * https://leetcode.com/problems/find-k-th-smallest-pair-distance<br><br>
 * 
 * Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is 
 * defined as the absolute difference between A and B.<br><br>
 * 
 * Note:<br>
 * 1. 2 <= len(nums) <= 10000.<br>
 * 2. 0 <= nums[i] < 1000000.<br>
 * 3. 1 <= k <= len(nums) * (len(nums) - 1) / 2.
 */
public class FindKthSmallestPairDistance {
    
    public static int solution(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int hi = nums[n-1] - nums[0];
        int lo = nums[1] - nums[0];
        for (int i = 1; i < n - 1; i++) {
            lo = Math.min(lo, nums[i+1] - nums[i]);
        }
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (countPairs(nums, mid) < k) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return lo;   
    }
    
    private static int countPairs(int[] nums, int mid) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && nums[j] - nums[i] <= mid) {
                j++;
            }
            res += j - i - 1;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 1};
        System.out.println(FindKthSmallestPairDistance.solution(nums, 1));
    }

}
