package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 296. Best Meeting Point<br/>
 * 
 * A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values
 * 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance,
 * where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.<br/><br/>
 * 
 * Hint: Try to solve it in one dimension first. How can this solution apply to the two dimension case?
 */
public class BestMeetingPoint {
    
    /**
     * in 1-D, C--A--P--B--D, the point P must be between A and B, so the shortest distance is D-C plus B-A
     * in 2D grid, just add distances in both x and y axis
     */
    public static int solution(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            throw new IllegalArgumentException();
        }
        
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        return helper(rows) + helper(cols);
    }
    
    private static int helper(List<Integer> list) {
        Collections.sort(list);
        int result = 0;
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            result += (list.get(j) - list.get(i));
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[][] grid = { {1, 0, 0, 0, 1},
                         {0, 0, 0, 0, 0},
                         {0, 0, 1, 0, 0} };
        System.out.println(BestMeetingPoint.solution(grid));
    }

}
