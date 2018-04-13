package edu.wz.cs.leetcode.medium;

/**
 * 348. Design Tic-Tac-Toe<br>
 * https://leetcode.com/problems/design-tic-tac-toe<br><br>
 * 
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.<br>
 * 
 * You may assume the following rules:<br>
 * 1. A move is guaranteed to be valid and is placed on an empty block.<br>
 * 2. Once a winning condition is reached, no more moves is allowed.<br>
 * 3. A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.<br>
 * 
 * Follow up: Could you do better than O(n2) per move() operation?<br>
 * 
 * Hint:<br>
 * 1. Could you trade extra space such that move() operation can be done in O(1)?<br>
 * 2. You need two arrays: int rows[n], int cols[n], plus two variables: diagonal, anti_diagonal.
 * 
 */
public class DesignTicTacToe {
    
    private int[][] board;
    
    public DesignTicTacToe(int n) {
        board = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        board[row][col] = player;
        
        int i = 0;
        int j = 0;
        int n = board.length;
        
        // check horizontal
        for (j = 1; j < n; j++) {
            if (board[row][j] != board[row][j-1]) {
                break;
            }
        }
        if (j == n) {
            return player;
        }
        
        // check verizontal
        for (i = 1; i < n; i++) {
            if (board[i][col] != board[i-1][col]) {
                break;
            }
        }
        if (i == n) {
            return player;
        }
        
        // check anti-diagonal
        if (row == col) {
            for (i = 1; i < n; i++) {
                if (board[i][i] != board[i-1][i-1]) {
                    break;
                }
            }
            if (i == n) {
                return player;
            }
        }
        
        // check diagonal
        if (row + col == n - 1) {
            for (i = 1; i < n; i++) {
                if (board[n-i-1][i] != board[n-i][i-1]) {
                    break;
                }
            }
            if (i == n) {
                return player;
            }
        }
        
        return 0;
    }

}
