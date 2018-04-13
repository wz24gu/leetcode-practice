package edu.wz.cs.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 281. Zigzag Iterator<br>
 * https://leetcode.com/problems/zigzag-iterator<br><br>
 * 
 * Given two 1d vectors, implement an iterator to return their elements alternately.<br>
 * 
 * For example, given two 1d vectors:<br>
 * v1 = [1, 2]<br>
 * v2 = [3, 4, 5, 6]<br>
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: 
 * [1, 3, 2, 4, 5, 6].<br>
 * 
 * Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
 */
public class ZigzagIterator {
    
    private Queue<Integer> queue;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<Integer>();
        int m = v1.size();
        int n = v2.size();
        int max = Math.max(m, n);
        for (int i = 0; i < max; i++) {
            if (i < m) {
                queue.offer(v1.get(i));
            }
            if (i < n) {
                queue.offer(v2.get(i));
            }
        }
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
    
    public static void main(String[] args) {
        List<Integer> v1 = Arrays.asList(new Integer[] {1, 2});
        List<Integer> v2 = Arrays.asList(new Integer[] {3, 4, 5, 6});
        ZigzagIterator iter = new ZigzagIterator(v1, v2);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

}
