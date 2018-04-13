package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges<br/>
 * https://leetcode.com/problems/summary-ranges<br/><br/>
 * 
 * Given a sorted integer array without duplicates, return the summary of its ranges.<br/><br/>
 * 
 * Example 1: Input: [0,1,2,4,5,7]; Output: ["0->2","4->5","7"]<br/>
 * 
 * Example 2: Input: [0,2,3,4,6,8,9]; Output: ["0","2->4","6","8->9"]
 */
public class SummaryRanges {
    
    public static List<String> solution(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int i = 0;
        while (i < nums.length) {
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[j-1] + 1) {
                j++;
            }
            if (j == i + 1) {
                result.add(nums[i] + "");
            }
            else {
                result.add(nums[i] + "->" + nums[j-1]);
            }
            
            i = j;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println(SummaryRanges.solution(nums));
        
        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(SummaryRanges.solution(nums2));
    }

}
