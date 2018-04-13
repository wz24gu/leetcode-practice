package edu.wz.cs.leetcode.easy;

/**
 * 463. Island Perimeter<br>
 * https://leetcode.com/problems/island-perimeter<br><br>
 * 
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid
 * cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there
 * is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that
 * isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular,
 * width and height don't exceed 100. Determine the perimeter of the island.
 */
public class IslandPerimeter {
    
    public static int solution(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int[][] dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count += 4;
                    
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                            count--;
                        }
                    }
                }
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        int[][] grid = { {0, 1, 0, 0},
                         {1, 1, 1, 0},
                         {0, 1, 0, 0},
                         {1, 1, 0, 0} };
        System.out.println(IslandPerimeter.solution(grid));
    }

}
