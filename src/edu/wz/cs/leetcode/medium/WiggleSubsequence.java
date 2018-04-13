package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 376. Wiggle Subsequence<br>
 * https://leetcode.com/problems/wiggle-subsequence<br><br>
 * 
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate 
 * between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence 
 * with fewer than two elements is trivially a wiggle sequence.<br>
 * 
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and 
 * negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two 
 * differences are positive and the second because its last difference is zero.<br>
 * 
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence 
 * is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the 
 * remaining elements in their original order.<br>
 * 
 * Follow up: Can you do it in O(n) time?
 */
public class WiggleSubsequence {
    
    public static int solutionX(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int p = 1;
        int q = 1;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i-1]) {
                p = q + 1;
            }
            else if (nums[i] < nums[i-1]) {
                q = p + 1;
            }
        }
        return Math.max(p, q);
    }
    
    public static int solutionDP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int[] p = new int[n];
        int[] q = new int[n];
        Arrays.fill(p, 1);
        Arrays.fill(q, 1);
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    p[i] = Math.max(p[i], q[j] + 1);
                }
                else if (nums[i] < nums[j]) {
                    q[i] = Math.max(q[i], p[j] + 1);
                }
            }
        }
        
        return Math.max(p[n-1], q[n-1]);
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 7, 4, 9, 2, 5};
        System.out.println(WiggleSubsequence.solutionX(nums));
        System.out.println(WiggleSubsequence.solutionDP(nums));
        
        int[] nums2 = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(WiggleSubsequence.solutionX(nums2));
        System.out.println(WiggleSubsequence.solutionDP(nums2));
        
        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(WiggleSubsequence.solutionX(nums3));
        System.out.println(WiggleSubsequence.solutionDP(nums3));
    }

}
