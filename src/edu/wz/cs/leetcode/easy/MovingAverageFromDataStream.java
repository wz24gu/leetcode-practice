package edu.wz.cs.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 346. Moving Average from Data Stream<br/>
 * 
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.<br/><br/>
 * 
 * For example:<br/>
 * MovingAverage m = new MovingAverage(3);<br/>
 * m.next(1) = 1<br/>
 * m.next(10) = (1 + 10) / 2<br/>
 * m.next(3) = (1 + 10 + 3) / 3<br/>
 * m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverageFromDataStream {
    
    private int size;
    private double sum;
    private Queue<Integer> queue;
    
    public MovingAverageFromDataStream(int size) {
        this.size = size;
        sum = 0;
        queue = new LinkedList<Integer>();
    }
    
    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        return sum / queue.size();
    }
    
    public static void main(String[] args) {
        MovingAverageFromDataStream m = new MovingAverageFromDataStream(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }

}
