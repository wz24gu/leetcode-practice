package edu.wz.cs.leetcode.medium;

/**
 * 200. Number of Islands<br>
 * https://leetcode.com/problems/number-of-islands<br><br>
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water 
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are 
 * all surrounded by water.
 */
public class NumberOfIslands {
    
    private static int[][] dirs = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    
    public static int solution(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, m, n);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private static void dfs(char[][] grid, int i, int j, int m, int n) {
        grid[i][j] = '9';
        
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                dfs(grid, x, y, m, n);
            }
        }
    }
    
    public static void main(String[] args) {
        char[][] grid = { {'1', '1', '1', '1', '0'},
                          {'1', '1', '0', '1', '0'},
                          {'1', '1', '0', '0', '0'},
                          {'0', '0', '0', '0', '0'} };
        System.out.println(NumberOfIslands.solution(grid));
        
        char[][] grid2 = { {'1', '1', '0', '0', '0'},
                           {'1', '1', '0', '0', '0'},
                           {'0', '0', '1', '0', '0'},
                           {'0', '0', '0', '1', '1'} };
        System.out.println(NumberOfIslands.solution(grid2));        
    }
    
}
