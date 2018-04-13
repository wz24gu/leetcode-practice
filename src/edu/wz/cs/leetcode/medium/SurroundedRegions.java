package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 130. Surrounded Regions<br>
 * https://leetcode.com/problems/surrounded-regions<br><br>
 * 
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.<br>
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */
public class SurroundedRegions {
    
    private static int[][] dirs = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    
    public static void solution(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    dfs(board, i, j, m, n);
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private static void dfs(char[][] board, int i, int j, int m, int n) {
        board[i][j] = '#';
        
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
                dfs(board, x, y, m, n);
            }
        }
    }
    
    public static void main(String[] args) {
        char[][] board = { {'X', 'X', 'X', 'X'},
                           {'X', 'O', 'O', 'X'},
                           {'X', 'X', 'O', 'X'},
                           {'X', 'O', 'X', 'X'} };
        SurroundedRegions.solution(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
    

}
