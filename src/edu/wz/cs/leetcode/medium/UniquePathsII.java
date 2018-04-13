package edu.wz.cs.leetcode.medium;

/**
 * 63. Unique Paths II<br>
 * https://leetcode.com/problems/unique-paths-ii<br><br>
 * 
 * Follow up for "Unique Paths":<br>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?<br>
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.<br>
 * 
 * Note: m and n will be at most 100.
 */
public class UniquePathsII {
    
    public static int solution(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0 || grid[0][0] == 1) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }
                else if (i == 0 && j > 0) {
                    dp[i][j] = dp[i][j-1];
                }
                else if (i > 0 && j == 0) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        
        return dp[m-1][n-1];
    }
    
    public static void main(String[] args) {
        int[][] grid = { {0, 0, 0}, 
                         {0, 1, 0},
                         {0, 0, 0} };
        System.out.println(UniquePathsII.solution(grid));
    }

}
