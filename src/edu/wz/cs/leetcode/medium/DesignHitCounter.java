package edu.wz.cs.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 362. Design Hit Counter<br>
 * https://leetcode.com/problems/design-hit-counter<br><br>
 * 
 * Design a hit counter which counts the number of hits received in the past 5 minutes.<br>
 * 
 * Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to 
 * the system in chronological order (i.e., the timestamp is monotonically increasing). You may assume that the 
 * earliest timestamp starts at 1. It is possible that several hits arrive roughly at the same time.<br>
 * 
 * Follow up: What if the number of hits per second could be very large? Does your design scale?
 */
public class DesignHitCounter {
    
    private Queue<Integer> queue;
    
    public DesignHitCounter() {
        queue = new LinkedList<Integer>();
    }
    
    public void hit(int timestamp) {
        queue.offer(timestamp);        
    }
    
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peek() >= 300) {
            queue.poll();
        }
        return queue.size();
    }
    
    public static void main(String[] args) {
        DesignHitCounter counter = new DesignHitCounter();
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        System.out.println(counter.getHits(4));
        counter.hit(300);
        System.out.println(counter.getHits(300));
        System.out.println(counter.getHits(301));
    }

}
