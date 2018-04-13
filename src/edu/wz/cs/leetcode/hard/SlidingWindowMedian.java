package edu.wz.cs.leetcode.hard;

import java.util.PriorityQueue;

/**
 * 480. Sliding Window Median<br/>
 * https://leetcode.com/problems/sliding-window-median<br/><br/>
 * 
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. 
 * So the median is the mean of the two middle value.<br/>
 * 
 * Examples: [2,3,4] , the median is 3<br/>
 * Examples: [2,3], the median is (2 + 3) / 2 = 2.5<br/>
 * 
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very 
 * right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your 
 * job is to output the median array for each window in the original array.<br/>
 * 
 * Note: You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
 */
public class SlidingWindowMedian {
    
    private static PriorityQueue<Integer> minHeap;
    private static PriorityQueue<Integer> maxHeap;
    
    public static double[] solution(int[] nums, int k) {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>((a, b) -> b.compareTo(a));
        
        int n = nums.length - k + 1;
        if (n <= 0) {
            return new double[0];
        }
        double[] result = new double[n];
        
        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) {  // sliding window is full
                result[i-k] = getMedian();
                remove(nums[i-k]);
            }
            if (i < nums.length) {
                add(nums[i]);
            }
        }
        
        return result;
    }
    
    private static void add(int num) {
        if (num < getMedian()) {
            maxHeap.add(num);
        }
        else {
            minHeap.add(num);
        }
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }        
    }
    
    private static void remove(int num) {
        if (num < getMedian()) {
            maxHeap.remove(num);
        }
        else {
            minHeap.remove(num);
        }
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    private static double getMedian() {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            return 0;
        }
        if (maxHeap.size() == minHeap.size()) {
            return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0;
        }
        else {
            return (double) minHeap.peek();
        }
    }

}
