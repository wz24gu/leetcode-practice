package edu.wz.cs.leetcode.hard;

/**
 * 327. Count of Range Sum<br>
 * https://leetcode.com/problems/count-of-range-sum<br><br>
 * 
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive. Range sum S(i, j) 
 * is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.<br>
 * 
 * Note: A naive algorithm of O(n2) is trivial. You MUST do better than that.<br><br>
 * 
 * Example: Given nums = [-2, 5, -1], lower = -2, upper = 2, Return 3.<br> 
 * The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
 */
public class CountOfRangeSum {
    
    public static int solutionBruteForce(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        long[] sum = new long[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (sum[j] - sum[i] >= lower && sum[j] - sum[i] <= upper) {
                    result++;
                }
            }
        }
        
        return result;
    }
    
    public static int solutionX(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        long[] sum = new long[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        return merge(sum, 0, n + 1, lower, upper);
    }
    
    private static int merge(long[] sum, int start, int end, int lower, int upper) {
        if (end <= start + 1) {
            return 0;
        }
        
        int mid = (start + end) / 2;
        int count = merge(sum, start, mid, lower, upper) + merge(sum, mid, end, lower, upper);
        
        int j = mid;
        int k = mid;
        int t = mid;
        long[] cache = new long[end - start];
        for (int i = start, r = 0; i < mid; i++, r++) { 
            while (k < end && sum[k] - sum[i] < lower) {
                k++;
            }
            while (j < end && sum[j] - sum[i] <= upper) {
                j++;
            }
            while (t < end && sum[t] < sum[i]) {
                cache[r++] = sum[t++];
            }
            cache[r] = sum[i];
            count += j - k;
        }
        
        System.arraycopy(cache, 0, sum, start, t - start);
        return count;
    }
    
    public static void main(String[] args) {
        int[] nums = {-2, 5, -1};
        System.out.println(CountOfRangeSum.solutionBruteForce(nums, -2, 2));
        System.out.println(CountOfRangeSum.solutionX(nums, -2, 2));
    }

}
