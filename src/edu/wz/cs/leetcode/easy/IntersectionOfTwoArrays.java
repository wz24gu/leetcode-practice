package edu.wz.cs.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349. Intersection of Two Arrays<br>
 * https://leetcode.com/problems/intersection-of-two-arrays<br><br>
 * 
 * Given two arrays, write a function to compute their intersection.<br><br>
 * 
 * Note:<br>
 * 1. Each element in the result must be unique.<br>
 * 2. The result can be in any order.
 */
public class IntersectionOfTwoArrays {
    
    public static int[] solution(int[] nums1, int[] nums2) {        
        Set<Integer> set = new HashSet<>();
        for (int n1 : nums1) {
            set.add(n1);
        }
        
        Set<Integer> intersect = new HashSet<>();
        for (int n2 : nums2) {
            if (set.contains(n2)) {
                intersect.add(n2);
            }
        }
        
        int[] result = new int[intersect.size()];
        int i = 0;
        for (int n : intersect) {
            result[i++] = n;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(IntersectionOfTwoArrays.solution(nums1, nums2)));
    }

}
