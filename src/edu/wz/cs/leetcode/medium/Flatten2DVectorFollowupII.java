package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 251. Flatten 2D Vector Follow up II<br>
 * https://leetcode.com/problems/flatten-2d-vector<br><br>
 */
public class Flatten2DVectorFollowupII {
    
    private Queue<Iterator<Integer>> queue;
    
    public Flatten2DVectorFollowupII(List<List<Integer>> vec2d) {
        queue = new LinkedList<Iterator<Integer>>();
        for (List<Integer> list : vec2d) {
            if (!list.isEmpty()) {
                queue.offer(list.iterator());
            }
        }
    }

    public Integer next() {
        Iterator<Integer> iter = queue.peek();
        int result = iter.next();
        if (!iter.hasNext()) {
            queue.poll();
        }
        return result;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
    
    public static void main(String[] args) {
        List<List<Integer>> vec2d = new ArrayList<>();
        vec2d.add(Arrays.asList(1, 2));
        vec2d.add(Arrays.asList(3));
        vec2d.add(Arrays.asList(4, 5, 6));
        Flatten2DVectorFollowupII flatten2DVectorFollowupII = new Flatten2DVectorFollowupII(vec2d);
        System.out.println(flatten2DVectorFollowupII.hasNext());
        System.out.println(flatten2DVectorFollowupII.next());
    }

}
