package edu.wz.cs.leetcode.easy;

import java.util.Arrays;

/**
 * 88. Merge Sorted Array<br>
 * https://leetcode.com/problems/merge-sorted-array<br><br>
 * 
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.<br>
 * 
 * Note: You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional 
 * elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class MergeSortedArray {
    
    public static void solution(int[] nums1, int m, int[] nums2, int n) {
        int[] aux = new int[m];
        for (int i = 0; i < m; i++) {
            aux[i] = nums1[i];
        }
        
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < m + n) {
            if (i >= m) {
                nums1[k++] = nums2[j++];
            }
            else if (j >= n) {
                nums1[k++] = aux[i++];
            }
            else if (aux[i] <= nums2[j]) {
                nums1[k++] = aux[i++];
            }
            else {
                nums1[k++] = nums2[j++];
            }
        }
    }
    
    public static void solutionX(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        
        while (k >= 0) {
            if (i < 0) {
                nums1[k--] = nums2[j--];
            }
            else if (j < 0) {
                return;
            }
            else if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            }
            else {
                nums1[k--] = nums2[j--];
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 6, 7, 9, 0, 0, 0, 0};
        int[] nums2 = {2, 5, 8, 10};
        MergeSortedArray.solutionX(nums1, 6, nums2, 4);
        System.out.println(Arrays.toString(nums1));
    }

}
