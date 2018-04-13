package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. Intersection of Two Arrays II<br>
 * https://leetcode.com/problems/intersection-of-two-arrays-ii<br><br>
 * 
 * Given two arrays, write a function to compute their intersection.<br>
 * 
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].<br><br>
 * 
 * Note:<br>
 * 1. Each element in the result should appear as many times as it shows in both arrays.<br>
 * 2. The result can be in any order.<br>
 * 
 * Follow up:<br>
 * 1. What if the given array is already sorted? How would you optimize your algorithm?<br>
 * 2. What if nums1's size is small compared to num2's size? Which algorithm is better?<br>
 * 3. What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements 
 * into the memory at once?
 */
public class IntersectionOfTwoArraysII {

    public static int[] solution(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int n : nums2) {
            if (map.containsKey(n) && map.get(n) > 0) {
                list.add(n);
                map.put(n, map.get(n) - 1);
            }
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    public static int[] solutionX(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            }
            else if (nums1[i] > nums2[j]) {
                j++;
            }
            else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        int[] result = new int[list.size()];
        for (int k = 0; k < result.length; k++) {
            result[k] = list.get(k);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(IntersectionOfTwoArraysII.solution(nums1, nums2)));
        System.out.println(Arrays.toString(IntersectionOfTwoArraysII.solutionX(nums1, nums2)));
    }
    
}
