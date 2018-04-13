package edu.wz.cs.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element<br>
 * https://leetcode.com/problems/majority-element<br><br>
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than 
 * floor(n/2) times.<br>
 * 
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
    
    public static int solution(int[] nums) {
        int max = 0;
        int result = nums[0];
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if (map.get(n) > max) {
                max = map.get(n);
                result = n;
            }
        }
        
        return result;
    }
    
    public static int solutionAlt(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    
    // Moore voting
    public static int solutionX(int[] nums) {
        int count = 0;
        int result = nums[0];
        for (int n : nums) {
            if (n == result) {
                count++;
            }
            else if (count == 0) {
                result = n;
                count++;
            }
            else {
                count--;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 7, 2, 3, 4, 1, 1, 2, 6, 6, 6, 6, 6, 6, 6, 6, 6};
        System.out.println(MajorityElement.solution(nums));
        System.out.println(MajorityElement.solutionAlt(nums));
        System.out.println(MajorityElement.solutionX(nums));
    }

}
