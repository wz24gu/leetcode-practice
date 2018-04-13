package edu.wz.cs.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 694. Number of Distinct Islands<br>
 * https://leetcode.com/problems/number-of-distinct-islands<br><br>
 * 
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 
 * 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.<br>
 * 
 * Count the number of distinct islands. An island is considered to be the same as another if and only if one island 
 * can be translated (and not rotated or reflected) to equal the other.<br>
 * 
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
public class NumberOfDistinctIslands {
    
    private static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public static int solution(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;        
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, 0, 0, sb);
                    set.add(sb.toString());
                }
            }
        }
        
        return set.size();        
    }
    
    private static void dfs(int[][] grid, int i, int j, int relativeX, int relativeY, StringBuilder sb) {
        grid[i][j] = 0;  // set it to 0 so we will not count it again
        sb.append(relativeX + "_" + relativeY);
        
        int m = grid.length;
        int n = grid[0].length;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                dfs(grid, x, y, relativeX + dir[0], relativeY + dir[1], sb);
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] grid = { {1, 1, 0, 0, 0},
                         {1, 1, 0, 0, 0},
                         {0, 0, 0, 1, 1},
                         {0, 0, 0, 1, 1} };
        System.out.println(NumberOfDistinctIslands.solution(grid));
        
        int[][] grid2 = { {1, 1, 0, 1, 1},
                          {1, 0, 0, 0, 0},
                          {0, 0, 0, 0, 1},
                          {1, 1, 0, 1, 1} };
        System.out.println(NumberOfDistinctIslands.solution(grid2));
    }

}
