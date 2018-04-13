package edu.wz.cs.leetcode.hard;

import java.util.Arrays;

/**
 * 493. Reverse Pairs<br>
 * https://leetcode.com/problems/reverse-pairs<br><br>
 * 
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].<br>
 * 
 * You need to return the number of important reverse pairs in the given array.<br>
 * 
 * Note:<br>
 * 1. The length of the given array will not exceed 50,000.<br>
 * 2. All the numbers in the input array are in the range of 32-bit integer.
 */
public class ReversePairs {
    
    private static int[] helper;
    
    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        helper = new int[nums.length];
        return merge(nums, 0, nums.length - 1);
    }
    
    private static int merge(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return 0;
        }
        
        int mid = lo + (hi - lo) / 2;
        int count = merge(nums, lo, mid) + merge(nums, mid + 1, hi);
        
        for (int i = lo, j = mid + 1; i <= mid; i++) {
            while (j <= hi && nums[i] / 2.0 > nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
        doMerge(nums, lo, mid, hi);
        
        return count;
    }    
    
    private static void doMerge(int[] nums, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            helper[i] = nums[i];
        }
        int p1 = lo;
        int p2 = mid + 1;
        int k = lo;
        while (p1 <= mid || p2 <= hi) {
            if (p1 > mid) {
                nums[k++] = helper[p2++];
            }
            else if (p2 > hi) {
                nums[k++] = helper[p1++];
            }
            else {                
                nums[k++] = (helper[p1] <= helper[p2]) ? helper[p1++] : helper[p2++];
            }
        }
    }
    
    // BIT Tree: needs work
    public static int solutionX(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int result = 0;
        int[] copy = Arrays.copyOf(nums, nums.length);
        int[] bit = new int[copy.length + 1];
        
        Arrays.sort(copy);
        
        for (int i : nums) {
            result += search(bit, index(copy, 2L * i +1));
            insert(bit, index(copy, i));
        }
        return result;
    }
    
    private static int index(int[] array, long val) {
        int l = 0;
        int r = array.length - 1;
        int m = 0;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            if (array[m] >= val) {
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }
        return l + 1;
    }
    
    private static int search(int[] bit, int i) {
        int sum = 0;
        while (i < bit.length) {
            sum += bit[i];
            i += (i & -i);
        }
        return sum;
    }
    
    private static void insert(int[] bit, int i) {
        while (i > 0) {
            bit[i] += 1;
            i -= (i & -i);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3, 1};
        System.out.println(ReversePairs.solution(nums));
        System.out.println(ReversePairs.solutionX(nums));
        
        int[] nums2 = {2, 4, 3, 5, 1};
        System.out.println(ReversePairs.solution(nums2));
        System.out.println(ReversePairs.solutionX(nums2));
    }

}
