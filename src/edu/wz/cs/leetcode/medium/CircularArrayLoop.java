package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 457. Circular Array Loop<br>
 * https://leetcode.com/problems/circular-array-loop<br><br>
 * 
 * You are given an array of positive and negative integers. If a number n at an index is positive, then move forward n 
 * steps. Conversely, if it's negative (-n), move backward n steps. Assume the first element of the array is forward next 
 * to the last element, and the last element is backward next to the first element. Determine if there is a loop in this 
 * array. A loop starts and ends at a particular index with more than 1 element along the loop. The loop must be 
 * "forward" or "backward'.<br>
 * 
 * Note: The given array is guaranteed to contain no element "0".<br>
 * 
 * Can you do it in O(n) time complexity and O(1) space complexity?
 */
public class CircularArrayLoop {
    
    public static boolean solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        boolean[] marked = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (marked[i]) {
                continue;
            }
            
            int curr = i;
            while (true) {
                marked[curr] = true;
                int next = (curr + nums[curr]) % n;
                if (next < 0) {
                    next += n;
                }
                
                if (next == curr || nums[next] * nums[curr] < 0) {
                    break;
                }
                
                if (map.containsKey(next)) {
                    return true;
                }
                map.put(curr, next);
                curr = next;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, -1, 1, 2, 2};
        System.out.println(CircularArrayLoop.solution(nums));
        
        int[] nums2 = {-1, 2};
        System.out.println(CircularArrayLoop.solution(nums2));
    }

}
