package edu.wz.cs.leetcode.algorithm;

public class BinarySearch {    
    
    // find the same element
    public int find_1(int[] nums, int k) {
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
    
    // find the first element that is not less than the target
    public int find_2(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < k) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1; 
            }
        }        
        return lo;  // if return lo - 1, it is the last element that is smaller than the target
    }
    
    // find the first element that is greater than the target
    public int find_3(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= k) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return lo;  // if return lo - 1, it is the last element that is not less that the target
    }
    
    

}
