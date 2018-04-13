package edu.wz.cs.leetcode.medium;

/**
 * 329. Longest Increasing Path in a Matrix<br>
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix<br><br>
 * 
 * Given an integer matrix, find the length of the longest increasing path.<br>
 * 
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move 
 * outside of the boundary (i.e. wrap-around is not allowed).
 */
public class LongestIncreasingPathInMatrix {
    
    private static int[][] dirs = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    
    public static int solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dfs(matrix, i, j, dp));
            }
        }
        return result;        
    }
    
    private static int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        
        int max = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            int len = 1 + dfs(matrix, x, y, dp);
            max = Math.max(max, len);
        }
        
        dp[i][j] = max;
        return max;
    }
    
    public static void main(String[] args) {
        int[][] matrix = { {9, 9, 4},
                           {6, 6, 8},
                           {2, 1, 1} };
        System.out.println(LongestIncreasingPathInMatrix.solution(matrix));
        
        int[][] matrix2 = { {3, 4, 5},
                            {3, 2, 6},
                            {2, 2, 1} };
        System.out.println(LongestIncreasingPathInMatrix.solution(matrix2));
    }

}
