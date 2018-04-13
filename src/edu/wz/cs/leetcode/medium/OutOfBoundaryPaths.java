package edu.wz.cs.leetcode.medium;

/**
 * 576. Out of Boundary Paths<br>
 * https://leetcode.com/problems/out-of-boundary-paths<br><br>
 * 
 * There is an m by n grid with a ball. Given the start coordinate (i,j) of the ball, you can move the ball to adjacent 
 * cell or cross the grid boundary in four directions (up, down, left, right). However, you can at most move N times. 
 * Find out the number of paths to move the ball out of grid boundary. The answer may be very large, return it after 
 * mod 109 + 7.<br><br>
 * 
 * Note:<br>
 * 1. Once you move the ball out of boundary, you cannot move it back.<br>
 * 2. The length and height of the grid is in range [1,50].<br>
 * 3. N is in range [0,50].
 */
public class OutOfBoundaryPaths {
    
    public static int solution(int m, int n, int N, int i, int j) {
        long[][][] dp = new long[N+1][m][n];
        
        for (int k = 1; k <= N; k++) {
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    long s1 = (x == 0) ? 1 : dp[k-1][x-1][y];
                    long s2 = (x == m - 1) ? 1 : dp[k-1][x+1][y];
                    long s3 = (y == 0) ? 1 : dp[k-1][x][y-1];
                    long s4 = (y == n - 1) ? 1 : dp[k-1][x][y+1];
                    dp[k][x][y] = s1 + s2 + s3 + s4;
                }
            }
        }
        
        return (int) (dp[N][i][j] % 1000000007);        
    }
    
    public static void main(String[] args) {
        System.out.println(OutOfBoundaryPaths.solution(2, 2, 2, 0, 0));
        System.out.println(OutOfBoundaryPaths.solution(1, 3, 3, 0, 1));
    }

}
