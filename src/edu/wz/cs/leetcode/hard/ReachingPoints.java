package edu.wz.cs.leetcode.hard;

/**
 * 780. Reaching Points<br>
 * https://leetcode.com/problems/reaching-points<br><br>
 * 
 * A move consists of taking a point (x, y) and transforming it to either (x, x+y) or (x+y, y).<br>
 * 
 * Given a starting point (sx, sy) and a target point (tx, ty), return True if and only if a sequence of moves exists 
 * to transform the point (sx, sy) to (tx, ty). Otherwise, return False.<br>
 * 
 * Note: sx, sy, tx, ty will all be integers in the range [1, 10^9].
 */
public class ReachingPoints {
    
    public static boolean solution(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) {
            return false;
        }
        if (sx == tx && (ty - sy) % sx == 0) {
            return true;
        }
        if (sy == ty && (tx - sx) % sy == 0) {
            return true;
        }
        
        return solution(sx, sy, tx % ty, ty % tx);
    }
    
    public static void main(String[] args) {
        System.out.println(ReachingPoints.solution(1, 1, 3, 5));
    }

}
