package edu.wz.cs.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 593. Valid Square<br>
 * https://leetcode.com/problems/valid-square<br><br>
 * 
 * Given the coordinates of four points in 2D space, return whether the four points could construct a square.<br>
 * 
 * The coordinate (x,y) of a point is represented by an integer array with two integers.<br><br>
 * 
 * Note:<br>
 * 1. All the input integers are in the range [-10000, 10000].<br>
 * 2. A valid square has four equal sides with positive length and four equal angles (90-degree angles).<br>
 * 3. Input points have no order.
 */
public class ValidSquare {
    
    public static boolean solution(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        set.add(dist(p1, p2));
        set.add(dist(p1, p3));
        set.add(dist(p1, p4));
        set.add(dist(p2, p3));
        set.add(dist(p2, p4));
        set.add(dist(p3, p4));
        return !set.contains(0) && set.size() == 2;
    }
    
    private static int dist(int[] p, int[] q) {
        return (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
    }
    
    public static void main(String[] args) {
        int[] p1 = {0, 0}, p2 = {1, 1}, p3 = {1, 0}, p4 = {0, 1};
        System.out.println(ValidSquare.solution(p1, p2, p3, p4));
    }

}
