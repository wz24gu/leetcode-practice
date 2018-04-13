package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 239. Sliding Window Maximum<br>
 * https://leetcode.com/problems/sliding-window-maximum<br><br>
 * 
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very 
 * right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.<br>
 * 
 * Note: You may assume k is always valid, i.e.: 1 <= k <= input array's size for non-empty array.<br>
 * 
 * Follow up: Could you solve it in linear time?
 */
public class SlidingWindowMaximum {
    
    public static int[] solution(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!queue.isEmpty() && queue.peekFirst() == i - k) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if (i >= k - 1) {
                list.add(nums[queue.peekFirst()]);
            }
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;        
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(SlidingWindowMaximum.solution(nums, 3)));
    }
    
    

}
