package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 215. Kth Largest Element in an Array<br>
 * https://leetcode.com/problems/kth-largest-element-in-an-array<br><br>
 * 
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not 
 * the kth distinct element.<br>
 * 
 * For example, Given [3,2,1,5,6,4] and k = 2, return 5.<br>
 * 
 * Note: You may assume k is always valid, 1 <= k <= array's length.
 */
public class KthLargestElementInArray {
    
    public static int solution(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    
    public static int solutionX(int[] nums, int k) {
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if (j < k) {
                lo = j + 1;
            }
            else if (j > k) {
                hi = j - 1;
            }
            else {
                return nums[j];
            }
        }        
        return nums[lo];
    }
    
    private static int partition(int[] nums, int lo, int hi) {
        int i = lo + 1;
        int j = hi;
        while (true) {
            while (i <= hi && nums[i] <= nums[lo]) {
                i++;
            }
            while (j >= lo + 1 && nums[j] >= nums[lo]) {
                j--;
            }
            if (i >= j) {
                break;
            }
            
            exchange(nums, i, j);
        }
        exchange(nums, lo, j);
        return j;        
    }
    
    private static void exchange(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(KthLargestElementInArray.solution(nums, 2));
        System.out.println(KthLargestElementInArray.solutionX(nums, 2));
    }

}
