package edu.wz.cs.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    
    public List<List<String>> solution(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        backtrack(board, 0, result);
        return result;
    }
    
    private void backtrack(char[][] board, int row, List<List<String>> result) {
        int n = board.length;
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new String(board[i]));
            }
            result.add(list);
        }
        
        for (int j = 0; j < n; j++) {
            if (valid(board, row, j)) {
                board[row][j] = 'Q';
                backtrack(board, row + 1, result);
                board[row][j] = '.';
            }
        }
    }
    
    private boolean valid(char[][] board, int row, int col) {
        int n = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < n; j++) {
              if (board[i][j] == 'Q' && (col == j || i + j == row + col || i - j == row - col)) {
                  return false;
              }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        NQueens queens = new NQueens();
        System.out.println(queens.solution(4));
    }

}
