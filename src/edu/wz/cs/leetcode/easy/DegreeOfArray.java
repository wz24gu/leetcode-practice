package edu.wz.cs.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. Degree of an Array<br>
 * https://leetcode.com/problems/degree-of-an-array<br><br>
 * 
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency
 * of any one of its elements. You task is to find the smallest possible length of a contiguous subarray of nums, that
 * has the same degree as nums.<br><br>
 * 
 * Note:<br>
 * 1. nums.length will be between 1 and 50,000.<br>
 * 2. nums[i] will be an integer between 0 and 49,999.
 */
public class DegreeOfArray {

    public static int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, int[]> position = new HashMap<>();
        int degree = 0;
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            degree = Math.max(degree, map.get(nums[i]));
            
            if (!position.containsKey(nums[i])) {
                position.put(nums[i], new int[2]);
                position.get(nums[i])[0] = i;
            }
            position.get(nums[i])[1] = i;
        }
        
        int min = nums.length;
        for (int n : map.keySet()) {            
            if (map.get(n) == degree) {
                min = Math.min(min, position.get(n)[1] - position.get(n)[0] + 1);
            }
        }
        return min;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1};
        System.out.println(DegreeOfArray.solution(nums));
        
        int[] nums2 = {1, 2, 2, 3, 1, 4, 2};
        System.out.println(DegreeOfArray.solution(nums2));
    }

}
