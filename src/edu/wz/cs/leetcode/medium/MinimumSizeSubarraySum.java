package edu.wz.cs.leetcode.medium;

/**
 * 209. Minimum Size Subarray Sum<br>
 * https://leetcode.com/problems/minimum-size-subarray-sum<br><br>
 * 
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of 
 * which the sum >= s. If there isn't one, return 0 instead.<br>
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem 
 * constraint.
 */
public class MinimumSizeSubarraySum {

    public static int solution(int[] nums, int s) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int result = n + 1;
        
        while (right < n) {
            while (right < n && sum < s) {
                sum += nums[right];
                right++;
            }
            
            while (sum >= s) {
                result = Math.min(result, right - left);
                sum -= nums[left];
                left++;
            }
        }
        
        return result == n + 1 ? 0 : result;
    }
    
    public static int solutionBinarySearch(int[] nums, int s) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int[] sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        
        int result = n + 1;
        for (int i = 0; i <= n; i++) {
            int right = search(i + 1, n, sum[i] + s, sum);
            if (right == n + 1) {
                break;
            }
            result = Math.min(result, right - i);
        }
        
        return result == n + 1 ? 0 : result;
    }
    
    private static int search(int lo, int hi, int key, int[] sum) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (sum[mid] >= key) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(MinimumSizeSubarraySum.solution(nums, 7));
        System.out.println(MinimumSizeSubarraySum.solutionBinarySearch(nums, 7));
    }
    
}
