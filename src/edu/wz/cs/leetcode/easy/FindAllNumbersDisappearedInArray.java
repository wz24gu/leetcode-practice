package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array<br>
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array<br><br>
 * 
 * Given an array of integers where 1 <= a[i] <= n (n = size of array), some elements appear twice and others appear
 * once. Find all the elements of [1, n] inclusive that do not appear in this array.<br>
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra 
 * space.
 */
public class FindAllNumbersDisappearedInArray {
    
    public static List<Integer> solution(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
    
    // this solution needs extra space
    public static List<Integer> solutionAlt(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int n = nums.length;
        int[] index = new int[n + 1];
        for (int i = 0; i < n; i++) {
            index[nums[i]]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (index[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(FindAllNumbersDisappearedInArray.solution(nums));
        
        int[] nums2 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(FindAllNumbersDisappearedInArray.solutionAlt(nums2));
    }

}
