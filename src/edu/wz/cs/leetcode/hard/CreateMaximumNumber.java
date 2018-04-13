package edu.wz.cs.leetcode.hard;

import java.util.Arrays;

/**
 * 321. Create Maximum Number<br>
 * https://leetcode.com/problems/create-maximum-number<br><br>
 * 
 * Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length 
 * k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an 
 * array of the k digits. You should try to optimize your time and space complexity.
 */
public class CreateMaximumNumber {
    
    public static int[] solution(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] result = new int[k];
        
        for (int i = Math.max(0, k - n2); i <= k && i <= n1; i++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, result, 0)) {
                result = candidate;
            }
        }
        return result;
    }
    
    private static int[] merge(int[] nums1, int[] nums2, int k) {
        int[] array = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++) {
            array[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return array;
    }
    
    private static int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] array = new int[k];
        for (int i = 0, j = 0; i < n; i++) {
            while (n - i + j > k && j > 0 && array[j-1] < nums[i]) {
                j--;
            }
            if (j < k) {
                array[j++] = nums[i];
            }
        }
        return array;
    }
    
    private static boolean greater(int[] nums1, int i, int[] nums2, int j) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        while (i < n1 && j < n2 && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == n2 || (i < n1 && nums1[i] > nums2[j]);
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(CreateMaximumNumber.solution(new int[] {3, 4, 6, 5},  new int[] {9, 1, 2, 5, 8, 3}, 5)));
        System.out.println(Arrays.toString(CreateMaximumNumber.solution(new int[] {6, 7},  new int[] {6, 0, 4}, 5)));
        System.out.println(Arrays.toString(CreateMaximumNumber.solution(new int[] {3, 9},  new int[] {8, 9}, 3)));
    }

}
