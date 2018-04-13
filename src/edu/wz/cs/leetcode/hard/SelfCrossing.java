package edu.wz.cs.leetcode.hard;

/**
 * 335. Self Crossing<br>
 * https://leetcode.com/problems/self-crossing<br><br>
 * 
 * You are given an array x of n positive numbers. You start at point (0,0) and moves x[0] metres to the north, then x[1] 
 * metres to the west, x[2] metres to the south, x[3] metres to the east and so on. In other words, after each move your 
 * direction changes counter-clockwise.<br>
 * 
 * Write a one-pass algorithm with O(1) extra space to determine, if your path crosses itself, or not.
 */
public class SelfCrossing {
    
    public static boolean solution(int[] x) {
        int n = x.length;
        for (int i = 3; i < n; i++) {
            if (x[i] >= x[i-2] && x[i-3] >= x[i-1]) {
                return true;
            }
            if (i >= 4 && x[i-1] == x[i-3] && x[i] >= x[i-2] - x[i-4]) {
                return true;
            }
            if (i >= 5 && x[i-2] >= x[i-4] && x[i-3] >= x[i-1]
                    && x[i-1] >= x[i-3] - x[i-5] && x[i] >= x[i-2] - x[i-4]) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[] x = {2, 1, 1, 2};
        System.out.println(SelfCrossing.solution(x));
        
        int[] x2 = {1, 2, 3, 4};
        System.out.println(SelfCrossing.solution(x2));
        
        int[] x3 = {1, 1, 1, 1};
        System.out.println(SelfCrossing.solution(x3));
    }

}
