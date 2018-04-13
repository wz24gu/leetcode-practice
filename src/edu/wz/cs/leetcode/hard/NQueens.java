package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N-Queens<br>
 * https://leetcode.com/problems/n-queens<br><br>
 * 
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each 
 * other.<br>
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle. Each solution contains a distinct board 
 * configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 */
public class NQueens {
    
    public static List<List<String>> solution(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        backtrack(board, 0, n, res);
        return res;
    }
    
    private static void backtrack(char[][] board, int r, int n, List<List<String>> res) {
        if (r == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new String(board[i]));
            }
            res.add(list);
            return;
        }        
        
        for (int c = 0; c < n; c++) {
            if (isValid(board, r, c, n)) {
                board[r][c] = 'Q';
                backtrack(board, r + 1, n, res);
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
        System.out.println(NQueens.solution(4));
        System.out.println(NQueens.solution(8));
    }

}
