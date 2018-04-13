package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. Find K Closest Elements<br>
 * https://leetcode.com/problems/find-k-closest-elements<br><br>
 * 
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be 
 * sorted in ascending order. If there is a tie, the smaller elements are always preferred.<br><br>
 * 
 * Note:<br>
 * 1. The value k is positive and will always be smaller than the length of the sorted array.<br>
 * 2. Length of the given array is positive and will not exceed 10^4<br>
 * 3. Absolute value of elements in the array and x will not exceed 10^4
 */
public class FindKClosestElements {
    
    public static List<Integer> solution(int[] nums, int k, int x) {
        int lo = 0;
        int hi = nums.length - k;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (x - nums[mid] > nums[mid + k] - x) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = lo; i < lo + k; i++) {
            result.add(nums[i]);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(FindKClosestElements.solution(nums, 4, 3));
        System.out.println(FindKClosestElements.solution(nums, 4, -1));
    }

}
