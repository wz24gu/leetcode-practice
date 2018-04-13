package edu.wz.cs.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 128. Longest Consecutive Sequence<br/>
 * https://leetcode.com/problems/longest-consecutive-sequence<br/><br/>
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.<br/>
 * 
 * For example, Given [100, 4, 200, 1, 3, 2],<br/>
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.<br/>
 * 
 * Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {
    
    public static int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }
            int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
            int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
            int sum = left + right + 1;
            map.put(num, sum);
            result = Math.max(result, sum);
            
            map.put(num - left, sum);
            map.put(num + right, sum);  // for clean purpose, we can also update all [num-left, num+right] to sum
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(LongestConsecutiveSequence.solution(nums));
    }

}
