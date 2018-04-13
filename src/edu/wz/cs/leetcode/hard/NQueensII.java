package edu.wz.cs.leetcode.hard;

import java.util.Arrays;

/**
 * 52. N Queens II<br>
 * 
 * Follow up for N-Queens problem.<br>
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class NQueensII {
    
    private static int count;
    
    public static int solution(int n) {
        if (n <= 0) {
            return 0;
        }
        
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        count = 0;
        backtrack(board, 0, n);
        return count;
    }
    
    private static void backtrack(char[][] board, int r, int n) {
        if (r == n) {
            count++;
            return;
        }
        
        for (int c = 0; c < n; c++) {
            if (isValid(board, r, c, n)) {
                board[r][c] = 'Q';
                backtrack(board, r + 1, n);
                board[r][c] = '.';
            }
        }
    }
    
    private static boolean isValid(char[][] board, int r, int c, int n) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Q') {
                    if (c == j || r + c == i + j || r - c == i - j) {
                        return false;
                    }
                }      
            }
        }        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(NQueensII.solution(4));
        System.out.println(NQueensII.solution(8));
    }

}
