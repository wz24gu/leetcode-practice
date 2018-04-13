package edu.wz.cs.leetcode.easy;

import java.util.Arrays;

/**
 * 189. Rotate Array<br>
 * https://leetcode.com/problems/rotate-array<br><br>
 * 
 * Rotate an array of n elements to the right by k steps.<br>
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].<br>
 * 
 * Note: Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 */
public class RotateArray {
    
    public static void solution(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        k = k % n;
        if (k == 0) {
            return;
        }
        
        int[] copy = Arrays.copyOf(nums, n);        
        for (int i = 0; i < n; i++) {
            nums[(i + k) % n] = copy[i];
        }
    }
    
    public static void solutionAlt(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        k = n % k;
        if (k == 0) {
            return;
        }        
        
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);        
    }
    
    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int swap = nums[i];
            nums[i++] = nums[j];
            nums[j--] = swap;
        }
    }
    
    public static void solutionAlt2(int[] nums, int k) {
        int n = nums.length;
        if (k >= n) {
            k %= n;
        }
        if (k == 0) {
            return;
        }
        
        int start = 0;
        int i = 0;
        int curr = nums[0];
        int count = 0;
        
        while (count++ < n) {
            i = (i + k) % n;
            int t = nums[i];
            nums[i] = curr;
            if  (i == start) {
                start++;
                i++;
                curr = nums[i];
            }
            else {
                curr = t;
            }
        }        
    }
    
    public static void solutionX(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        k = k % n;
        if (k == 0) {
            return;
        }
        
        for (int i = 0; i < k; i++) {
            int tmp = nums[n-1];
            for (int j = n - 2; j >= 0; j--) {
                nums[j+1] = nums[j];
            }
            nums[0] = tmp;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
        RotateArray.solution(nums, 3);
        System.out.println(Arrays.toString(nums));
        
        int[] nums2 = new int[] {1, 2, 3, 4, 5, 6, 7};
        RotateArray.solutionAlt(nums2, 3);
        System.out.println(Arrays.toString(nums2));
        
        int[] nums3 = new int[] {1, 2, 3, 4, 5, 6, 7};
        RotateArray.solutionAlt2(nums3, 3);
        System.out.println(Arrays.toString(nums3));
    }

}
