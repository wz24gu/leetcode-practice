package edu.wz.cs.leetcode.hard;

import java.util.Arrays;

/**
 * 4. Median of Two Sorted Arrays<br>
 * https://leetcode.com/problems/median-of-two-sorted-arrays<br><br>
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.<br>
 * 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {
    
    public static double solution(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, nums2, left) + findKth(nums1, nums2, right)) / 2.0;
    }
    
    private static int findKth(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findKth(nums2, nums1, k);
        }
        if (m == 0) {
            return nums2[k-1];
        }
        if (k == 1) {
            return Math.min(nums1[0], nums2[0]);
        }
        
        int i = Math.min(m, k / 2);
        int j = Math.min(n, k / 2);
        if (nums1[i-1] > nums2[j-1]) {
            return findKth(nums1, Arrays.copyOfRange(nums2, j, n), k - j);
        }
        else {
            return findKth(Arrays.copyOfRange(nums1, i, m), nums2, k - i);
        }        
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(MedianOfTwoSortedArrays.solution(nums1, nums2));
        
        nums1 = new int[] {1, 2};
        nums2 = new int[] {3, 4};
        System.out.println(MedianOfTwoSortedArrays.solution(nums1, nums2));
    }

}
