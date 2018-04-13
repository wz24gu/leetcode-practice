package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 699. Falling Squares<br>
 * https://leetcode.com/problems/falling-squares<br><br>
 * 
 * On an infinite number line (x-axis), we drop given squares in the order they are given.<br>
 * 
 * The i-th square dropped (positions[i] = (left, side_length)) is a square with the left-most point being positions[i][0] 
 * and sidelength positions[i][1].<br>
 * 
 * The square is dropped with the bottom edge parallel to the number line, and from a higher height than all currently 
 * landed squares. We wait for each square to stick before dropping the next.<br>
 * 
 * The squares are infinitely sticky on their bottom edge, and will remain fixed to any positive length surface they touch 
 * (either the number line or another square). Squares dropped adjacent to each other will not stick together prematurely.<br>
 * 
 * Return a list ans of heights. Each height ans[i] represents the current highest height of any square we have dropped, 
 * after dropping squares represented by positions[0], positions[1], ..., positions[i].
 */
public class FallingSquares {
    
    private static class Interval {
        int start;
        int end;
        int height;
        public Interval(int start, int end, int height) {
            this.start = start;
            this.end = end;
            this.height = height;
        }
    }
    
    public static List<Integer> solution(int[][] positions) {
        List<Interval> intervals = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int height = 0;
        for (int[] pos : positions) {
            Interval cur = new Interval(pos[0], pos[0] + pos[1] - 1, pos[1]);
            height = Math.max(height, getHeight(intervals, cur));
            res.add(height);
        }
        return res;
    }
    
    private static int getHeight(List<Interval> intervals, Interval cur) {
        int preH = 0;
        for (Interval i : intervals) {
            if (i.end < cur.start) {
                continue;
            }
            if (i.start > cur.end) {
                continue;
            }
            preH = Math.max(preH, i.height);
        }
        cur.height += preH;
        intervals.add(cur);
        return cur.height;
    }
    
    public static void main(String[] args) {
        int[][] positions = { {1, 2}, {2, 3}, {6, 1} };
        System.out.println(FallingSquares.solution(positions));
    }

}
