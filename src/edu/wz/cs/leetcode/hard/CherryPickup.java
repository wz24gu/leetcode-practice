package edu.wz.cs.leetcode.hard;

/**
 * 741. Cherry Pickup<br>
 * https://leetcode.com/problems/cherry-pickup<br><br>
 * 
 * In a N x N grid representing a field of cherries, each cell is one of three possible integers.<br>
 * 0 means the cell is empty, so you can pass through;<br>
 * 1 means the cell contains a cherry, that you can pick up and pass through;<br>
 * -1 means the cell contains a thorn that blocks your way.<br>
 * 
 * Your task is to collect maximum number of cherries possible by following the rules below:<br>
 * 1. Starting at the position (0, 0) and reaching (N-1, N-1) by moving right or down through valid path cells (cells 
 * with value 0 or 1);<br>
 * 2. After reaching (N-1, N-1), returning to (0, 0) by moving left or up through valid path cells;<br>
 * 3. When passing through a path cell containing a cherry, you pick it up and the cell becomes an empty cell (0);<br>
 * 4. If there is no valid path between (0, 0) and (N-1, N-1), then no cherries can be collected.<br><br>
 * 
 * Note:<br>
 * 1. grid is an N by N 2D array, with 1 <= N <= 50.<br>
 * 2. Each grid[i][j] is an integer in the set {-1, 0, 1}.<br>
 * 3. It is guaranteed that grid[0][0] and grid[N-1][N-1] are not -1.
 */
public class CherryPickup {
    
    public static int solution(int[][] grid) {
        int N = grid.length;
        int[][] dp = new int[N][N];
        dp[0][0] = grid[0][0];
        
        int M = (N << 1) - 1;
        for (int n = 1; n < M; n++) {
            for (int i = N - 1; i >= 0; i--) {
                for (int p = N - 1; p >= 0; p--) {
                    int j = n - i;
                    int q = n - p;
                    
                    if (j < 0 || j >= N || q < 0 || q >= N || grid[i][j] < 0 || grid[p][q] < 0) {
                        dp[i][p] = -1;
                        continue;
                    }
                    
                    if (i > 0) {
                        dp[i][p] = Math.max(dp[i][p], dp[i-1][p]);
                    }
                    if (p > 0) {
                        dp[i][p] = Math.max(dp[i][p], dp[i][p-1]);
                    }
                    if (i > 0 && p > 0) {
                        dp[i][p] = Math.max(dp[i][p], dp[i-1][p-1]);
                    }
                    if (dp[i][p] >= 0) {
                        dp[i][p] += grid[i][j] + (i != p ? grid[p][q] : 0);
                    }
                }
            }
        }
        
        return Math.max(dp[N-1][N-1], 0);
    }
    
    public static void main(String[] args) {
        int[][] grid = { {0, 1, -1},
                         {1, 0, -1},
                         {1, 1, 1} };
        System.out.println(CherryPickup.solution(grid));
    }

}
