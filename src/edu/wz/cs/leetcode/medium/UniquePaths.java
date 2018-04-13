package edu.wz.cs.leetcode.medium;

/**
 * 62. Unique Paths<br>
 * https://leetcode.com/problems/unique-paths<br><br>
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).<br>
 * 
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right 
 * corner of the grid (marked 'Finish' in the diagram below).<br>
 * 
 * How many possible unique paths are there?<br>
 * 
 * Note: m and n will be at most 100.
 */
public class UniquePaths {
    
    public static int solution(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;  // first column, go down only
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;  // first row, go right only
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    
    public static void main(String[] args) {
        System.out.println(UniquePaths.solution(3, 7));
    }

}
