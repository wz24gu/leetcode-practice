package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 251. Flatten 2D Vector<br>
 * https://leetcode.com/problems/flatten-2d-vector<br><br>
 * 
 * Implement an iterator to flatten a 2d vector.<br>
 * For example, Given 2d vector = [ [1,2], [3], [4,5,6] ], By calling next repeatedly until hasNext returns false, 
 * the order of elements returned by next should be: [1,2,3,4,5,6].<br>
 * 
 * Follow up:<br>
 * As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 */
public class Flatten2DVectorFollowupI {
    
    private List<List<Integer>> vec2d;
    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;
    
    public Flatten2DVectorFollowupI(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        i = this.vec2d.iterator();
        hasNext();
    }

    public Integer next() {
        return j.next();
    }

    public boolean hasNext() {
        while ((j == null || !j.hasNext()) && i.hasNext()) {
            j = i.next().iterator();
        }
        return j != null && j.hasNext();
    }
    
    public static void main(String[] args) {
        List<List<Integer>> vec2d = new ArrayList<>();
        vec2d.add(Arrays.asList(1, 2));
        vec2d.add(Arrays.asList(3));
        vec2d.add(Arrays.asList(4, 5, 6));
        Flatten2DVectorFollowupI Flatten2DVectorFollowupI = new Flatten2DVectorFollowupI(vec2d);
        System.out.println(Flatten2DVectorFollowupI.hasNext());
        System.out.println(Flatten2DVectorFollowupI.next());
    }

}
