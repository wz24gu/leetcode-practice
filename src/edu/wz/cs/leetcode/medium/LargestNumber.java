package edu.wz.cs.leetcode.medium;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 179. Largest Number<br>
 * https://leetcode.com/problems/largest-number<br><br>
 * 
 * Given a list of non negative integers, arrange them such that they form the largest number.<br>
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.<br>
 * 
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
    
    public static String solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        
        Queue<String> pq = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));
        for (int num : nums) {
            pq.offer(String.valueOf(num));
        }
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(LargestNumber.solution(nums));
    }

}
