package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array<br>
 * https://leetcode.com/problems/find-all-duplicates-in-an-array<br><br>
 * 
 * Given an array of integers, 1 <= a[i] <= n (n = size of array), some elements appear twice and others appear once. 
 * Find all the elements that appear twice in this array.<br>
 * 
 * Could you do it without extra space and in O(n) runtime?
 */
public class FindAllDuplicatesInArray {
    
    public static List<Integer> solution(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;            
            if (nums[index] < 0) {
                result.add(index + 1);
            }
            else {
                nums[index] *= -1;
            }
        }
        return result;        
    }
    
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(FindAllDuplicatesInArray.solution(nums));
        System.out.println(Arrays.toString(nums));
    }

}
