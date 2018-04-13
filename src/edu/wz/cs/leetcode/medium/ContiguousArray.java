package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. Contiguous Array<br>
 * https://leetcode.com/problems/contiguous-array<br><br>
 * 
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.<br>
 * 
 * Note: The length of the given binary array will not exceed 50,000.
 */
public class ContiguousArray {
    
    public static int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int n = nums.length;
        int result = 0;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            sum += (nums[i] == 1) ? 1 : -1;
            if (map.containsKey(sum)) {
                result = Math.max(result, i - map.get(sum));
            }
            else {
                map.put(sum, i);
            }
        }
        System.out.println(map);
        return result;        
    }
    
    public static void main(String[] args) {
        int[] nums = {0, 1};
        System.out.println(ContiguousArray.solution(nums));
        
        int[] nums2 = {0, 1, 0};
        System.out.println(ContiguousArray.solution(nums2));
    }

}
