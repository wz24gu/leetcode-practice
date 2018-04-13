package edu.wz.cs.leetcode.medium;

/**
 * 562. Longest Line of Consecutive One in Matrix<br>
 * https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix<br><br>
 * 
 * Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal, vertical, 
 * diagonal or anti-diagonal.<br>
 * 
 * Hint: The number of elements in the given matrix will not exceed 10,000.
 */
public class LongestLineOfConsecutiveOneInMatrix {
    
    public static int solution(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        
        int result = 0;
        int m = M.length;
        int n = M[0].length;
        
        // horizontal
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    count++;
                    result = Math.max(result, count);
                }
                else {
                    count = 0;
                }
            }
        }
        // vertical
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (M[i][j] == 1) {
                    count++;
                    result = Math.max(result, count);
                }
                else {
                    count = 0;
                }
            }
        }
        // diagonal and anti-diagonal
        for (int i = 0; i < m + n - 1; i++) {
            int count1 = 0;
            int count2 = 0;
            for (int j = i; j >= 0; j--) {
                if (i - j < m && j < n) {
                    if (M[i-j][j] == 1) {
                        count1++;
                        result = Math.max(result, count1);
                    }
                    else {
                        count1 = 0;
                    }
                }
                
                int t = m - 1 - i + j;
                if (t >= 0 && t < m && j < n) {
                    if (M[t][j] == 1) {
                        count2++;
                        result = Math.max(result, count2);
                    }
                    else {
                        count2 = 0;
                    }
                }
            }
        }
        
        return result;
    }
    
    public static int solutionDFS(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        
        int[][] dirs = { {1, 0}, {0, 1}, {-1, -1}, {-1, 1} };
        int m = M.length;
        int n = M[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 0) {
                    continue;
                }
                
                for (int[] dir : dirs) {
                    int count = 0;
                    int x = i;
                    int y = j;
                    while (x >= 0 && x < m && y >= 0 && y < n && M[x][y] == 1) {
                        x += dir[0];
                        y += dir[1];
                        count++;
                    }
                    result = Math.max(result, count);
                }                
            }
        }
        
        return result;        
    }
    
    public static void main(String[] args) {
        int[][] M = { {0, 1, 1, 0},
                      {0, 1, 1, 0},
                      {0, 0, 0, 1} };
        System.out.println(LongestLineOfConsecutiveOneInMatrix.solution(M));
        System.out.println(LongestLineOfConsecutiveOneInMatrix.solutionDFS(M));
    }

}
