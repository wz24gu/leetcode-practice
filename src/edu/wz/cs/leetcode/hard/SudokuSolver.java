package edu.wz.cs.leetcode.hard;

import java.util.Arrays;

/**
 * 37. Sudoku Solver<br>
 * https://leetcode.com/problems/sudoku-solver<br><br>
 * 
 * Write a program to solve a Sudoku puzzle by filling the empty cells.<br>
 * 
 * Empty cells are indicated by the character '.'.<br>
 * 
 * You may assume that there will be only one unique solution.
 */
public class SudokuSolver {
    
    public static void solution(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        solve(board, 0, 0);
    }
    
    private static boolean solve(char[][] board, int i, int j) {
        if (i == 9) {
            return true;
        }
        if (j == 9) {
            return solve(board, i + 1, 0);
        }
        
        if (board[i][j] == '.') {
            for (char k = '1'; k <= '9'; k++) {
                board[i][j] = k;
                if (valid(board, i, j)) {
                    if (solve(board, i, j + 1)) {
                        return true;
                    }
                }
                board[i][j] = '.';
            }
        }
        else {
            return solve(board, i, j + 1);
        }
        
        return false;
    }
    
    private static boolean valid(char[][] board, int i, int j) {
        // check in the same row
        for (int col = 0; col < 9; col++) {
            if (col != j && board[i][j] == board[i][col]) {
                return false;
            }
        }
        // check in the same column
        for (int row = 0; row < 9; row++) {
            if (row != i && board[i][j] == board[row][j]) {
                return false;
            }
        }
        // check in the 3x3 matrix
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
                if ((row != i || col != j) && board[i][j] == board[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        char[][] board = { {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                           {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                           {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                           {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                           {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                           {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                           {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                           {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                           {'.', '.', '.', '.', '8', '.', '.', '7', '9'} };
        SudokuSolver.solution(board);
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println();
        
        char[][] board2 = { {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                            {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                            {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                            {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                            {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                            {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                            {'.', '.', '.', '2', '7', '5', '9', '.', '.'} };
        SudokuSolver.solution(board2);
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board2[i]));
        }
    }

}
