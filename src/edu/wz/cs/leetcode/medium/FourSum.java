package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 18. 4 Sum<br>
 * https://leetcode.com/problems/4sum<br><br>
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all 
 * unique quadruplets in the array which gives the sum of target.<br>
 * 
 * Note: The solution set must not contain duplicate quadruplets.
 */
public class FourSum {
    
    public static List<List<Integer>> solution(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int lo = j + 1;
                int hi = n - 1;
                while (lo < hi) {
                    int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                    if (sum < target) {
                        lo++;
                    }
                    else if (sum > target) {
                        hi--;
                    }
                    else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[lo]);
                        list.add(nums[hi]);
                        set.add(list);
                        lo++;
                        hi--;
                    }
                }   
            }
        }
        
        result.addAll(set);
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(FourSum.solution(nums, 0));
    }

}
