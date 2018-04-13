package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 34. Search for a Range<br>
 * https://leetcode.com/problems/search-for-a-range<br><br>
 * 
 * Given a sorted array of integers, find the starting and ending position of a given target value.<br>
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).<br>
 * 
 * If the target is not found in the array, return [-1, -1].
 */
public class SearchForARange {
    
    public static int[] solution(int[] nums, int target) {
        int idx = search(nums, target);
        if (idx == -1) {
            return new int[] {-1, -1};
        }
        
        int lo = idx;
        int hi = idx;
        while (lo > 0 && nums[lo-1] == target) {
            lo--;
        }
        while (hi < nums.length - 1 && nums[hi+1] == target) {
            hi++;
        }
        return new int[] {lo, hi};
    }
    
    public static int search(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < k) {
                lo = mid + 1;
            }
            else if (nums[mid] > k) {
                hi = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
    
    public static int[] solutionX(int[] nums, int target) {
        int[] result = {-1, -1};
        
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        
        if (nums[hi] != target) {
            return result;
        }        
        result[0] = hi;
        
        hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= target) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        result[1] = lo - 1;
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(SearchForARange.solution(nums, 8)));
        System.out.println(Arrays.toString(SearchForARange.solutionX(nums, 8)));
    }

}
