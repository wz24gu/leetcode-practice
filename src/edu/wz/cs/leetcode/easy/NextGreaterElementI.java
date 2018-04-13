package edu.wz.cs.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. Next Greater Element I<br>
 * https://leetcode.com/problems/next-greater-element-i<br><br>
 * 
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1's elements are subset of nums2. Find all
 * the next greater numbers for nums1's elements in the corresponding places of nums2. The Next Greater Number of a
 * number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.<br><br>
 * 
 * Note:<br>
 * 1. All elements in nums1 and nums2 are unique.<br>
 * 2. The length of both nums1 and nums2 would not exceed 1000.
 */
public class NextGreaterElementI {
    
    public static int[] solution(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0
                || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        int[] result = new int[nums1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }
    
    public static int[] solutionX(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0
                || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length - 1; i++) {
            if (nums2[i] < nums2[i+1]) {
                map.put(nums2[i], nums2[i+1]);
                while (!stack.isEmpty() && stack.peek() < nums2[i+1]) {
                    map.put(stack.pop(), nums2[i+1]);
                }
            }
            else {
                stack.push(nums2[i]);
            }
        }
        
        int[] result = new int[nums1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(NextGreaterElementI.solution(nums1, nums2)));
        System.out.println(Arrays.toString(NextGreaterElementI.solutionX(nums1, nums2)));
        
        int[] nums3 = {2, 4};
        int[] nums4 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(NextGreaterElementI.solution(nums3, nums4)));
        System.out.println(Arrays.toString(NextGreaterElementI.solutionX(nums3, nums4)));
    }

}
