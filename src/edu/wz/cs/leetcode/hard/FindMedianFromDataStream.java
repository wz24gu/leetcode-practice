package edu.wz.cs.leetcode.hard;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 295. Find Median from Data Stream<br>
 * https://leetcode.com/problems/find-median-from-data-stream<br><br>
 * 
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So 
 * the median is the mean of the two middle value.<br>
 * 
 * Examples: [2,3,4] , the median is 3<br>
 * [2,3], the median is (2 + 3) / 2 = 2.5<br>
 * 
 * Design a data structure that supports the following two operations:<br>
 * 1. void addNum(int num) - Add a integer number from the data stream to the data structure.<br>
 * 2. double findMedian() - Return the median of all elements so far.
 */
public class FindMedianFromDataStream {
    
    private Queue<Integer> large;
    private Queue<Integer> small;
    
    /** initialize your data structure here. */
    public FindMedianFromDataStream() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        small.offer(num);
        large.offer(small.poll());
        if (small.size() < large.size()) {
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        if (large.size() == small.size()) {
            return (large.peek() + small.peek()) / 2.0;
        }
        else {
            return small.peek();
        }
    }
    
    public static void main(String[] args) {
        FindMedianFromDataStream finder = new FindMedianFromDataStream();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
    }

}
