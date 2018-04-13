package edu.wz.cs.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 594. Longest Harmonious Subsequence<br>
 * https://leetcode.com/problems/longest-harmonious-subsequence<br><br>
 * 
 * We define a harmonious array is an array where the difference between its maximum value and its minimum value is 
 * exactly 1.<br>
 * 
 * Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its 
 * possible subsequences.<br>
 * 
 * Example 1:<br>
 * Input: [1,3,2,2,5,2,3,7]<br>
 * Output: 5<br>
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].<br>
 * 
 * Note: The length of the input array will not exceed 20,000.
 */
public class LongestHarmoniousSubsequence {
    
    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }        
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int result = 0;
        for (int n : map.keySet()) {
            if (map.containsKey(n + 1)) {
                result = Math.max(result, map.get(n) + map.get(n + 1));
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(LongestHarmoniousSubsequence.solution(nums));
    }

}
