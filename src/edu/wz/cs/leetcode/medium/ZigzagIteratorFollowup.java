package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 281. Zigzag Iterator Follow-up<br>
 * https://leetcode.com/problems/zigzag-iterator<br><br>
 * 
 * Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
 */
public class ZigzagIteratorFollowup {
    
    private Queue<Iterator<Integer>> queue;
    
    public ZigzagIteratorFollowup(List<List<Integer>> lists) {
        queue = new LinkedList<Iterator<Integer>>();
        for (List<Integer> list : lists) {
            if (!list.isEmpty()) {
                queue.offer(list.iterator());
            }
        }        
    }

    public int next() {
        Iterator<Integer> iter = queue.poll();
        int result = iter.next();
        if (iter.hasNext()) {
            queue.offer(iter);
        }
        return result;
    }

    public boolean hasNext() {
       return !queue.isEmpty();
    }
    
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(new Integer[] {1, 2}));
        lists.add(Arrays.asList(new Integer[] {3, 4, 5, 6}));
        
        ZigzagIteratorFollowup iter = new ZigzagIteratorFollowup(lists);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

}
