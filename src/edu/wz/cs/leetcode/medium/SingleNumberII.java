package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 137. Single Number II<br>
 * https://leetcode.com/problems/single-number-ii<br><br>
 * 
 * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that 
 * single one.<br>
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumberII {
    
    public static int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int result = 0;
        for (int num : map.keySet()) {
            if (map.get(num) != 3) {
                result = num;
            }
        }
        return result;
    }
    
    public static int solutionX(int[]  nums) {
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i) & 1;
            }
            result += (sum % 3) << i;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 3, 3, 5};
        System.out.println(SingleNumberII.solution(nums));
        System.out.println(SingleNumberII.solutionX(nums));
    }

}
