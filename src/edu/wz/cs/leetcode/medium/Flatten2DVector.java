package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
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
public class Flatten2DVector {
    
    private List<List<Integer>> vec2d;
    private int x;
    private int y;
    
    public Flatten2DVector(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        x = 0;
        y = 0;
    }

    public Integer next() {
        int i = vec2d.get(x).get(y++);
        return i;
    }

    public boolean hasNext() {
        int n = vec2d.size();
        while (y == vec2d.get(x).size() && x < n) {
            x++;
            y = 0;
        }
        return x < n;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> vec2d = new ArrayList<>();
        vec2d.add(Arrays.asList(1, 2));
        vec2d.add(Arrays.asList(3));
        vec2d.add(Arrays.asList(4, 5, 6));
        Flatten2DVector flatten2DVector = new Flatten2DVector(vec2d);
        System.out.println(flatten2DVector.hasNext());
        System.out.println(flatten2DVector.next());
    }

}
