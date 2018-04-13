package edu.wz.cs.leetcode.easy;

/**
 * 695. Max Area of Island<br>
 * https://leetcode.com/problems/max-area-of-island<br><br>
 * 
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected
 * 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water. Find the
 * maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)<br><br>
 * 
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
public class MaxAreaOfIsland {
    
    public static int solution(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int max = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }
    
    private static int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] <= 0) {
            return 0;
        }
        
        int area = 1;
        grid[i][j] = -1;  // set grid[i][j] = -1 so that it will not be calculated again
        area += (dfs(grid, i - 1, j)
               + dfs(grid, i + 1, j)
               + dfs(grid, i, j - 1)
               + dfs(grid, i, j + 1));
        return area;
    }
    
    public static void main(String[] args) {
        int[][] grid = { {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                         {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                         {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0} };
        
        System.out.println(MaxAreaOfIsland.solution(grid));
    }

}
