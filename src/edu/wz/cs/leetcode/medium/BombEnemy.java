package edu.wz.cs.leetcode.medium;

/**
 * 361. Bomb Enemy<br>
 * https://leetcode.com/problems/bomb-enemy<br><br>
 * 
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum 
 * enemies you can kill using one bomb.<br>
 * 
 * The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the 
 * wall is too strong to be destroyed.<br>
 * 
 * Note that you can only put the bomb at an empty cell.
 */
public class BombEnemy {
    
    public static int solution(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] v1 = new int[m][n];
        int[][] v2 = new int[m][n];
        int[][] v3 = new int[m][n];
        int[][] v4 = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int t = (j == 0 || grid[i][j] == 'W') ? 0 : v1[i][j-1];
                v1[i][j] = (grid[i][j] == 'E') ? t + 1 : t;
            }
            for (int j = n - 1; j >= 0; j--) {
                int t = (j == n - 1 || grid[i][j] == 'W') ? 0 : v2[i][j + 1];
                v2[i][j] = (grid[i][j] == 'E') ? t + 1 : t;
            }
        }
        
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                int t = (i == 0 || grid[i][j] == 'W') ? 0 : v3[i-1][j];
                v3[i][j] = (grid[i][j] == 'E') ? t + 1 : t;
            }
            for (int i = m - 1; i >= 0; i--) {
                int t = (i == m - 1 || grid[i][j] == 'W') ? 0 : v4[i+1][j];
                v4[i][j] = (grid[i][j] == 'E') ? t + 1 : t;
            }
        }
        
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    result = Math.max(result, v1[i][j] + v2[i][j] + v3[i][j] + v4[i][j]);
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        char[][] grid = { {'0', 'E', '0', '0'},
                          {'E', '0', 'W', 'E'},
                          {'0', 'E', '0', '0'} };
        System.out.println(BombEnemy.solution(grid));
    }

}
