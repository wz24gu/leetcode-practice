package edu.wz.cs.leetcode.medium;

/**
 * 289. Game of Life<br>
 * https://leetcode.com/problems/game-of-life<br><br>
 * 
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised 
 * by the British mathematician John Horton Conway in 1970."<br>
 * 
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its 
 * eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):<br>
 * 1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.<br>
 * 2. Any live cell with two or three live neighbors lives on to the next generation.<br>
 * 3. Any live cell with more than three live neighbors dies, as if by over-population.<br>
 * 4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.<br>
 * 
 * Write a function to compute the next state (after one update) of the board given its current state.<br>
 * 
 * Follow up: Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot 
 * update some cells first and then use their updated values to update other cells. In this question, we represent the 
 * board using a 2D array. In principle, the board is infinite, which would cause problems when the active area 
 * encroaches the border of the array. How would you address these problems?
 */
public class GameOfLife {
    
    public static void solution(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        int[][] dirs = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        
        // 0 dead -> dead; 1 dead -> live; 2 live -> dead; 3 live -> live
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }                    
                    if (board[x][y] == 1 || board[x][y] == 2) {
                        count++;
                    }                    
                }
                
                if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 2;
                }
                else if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 3;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] %= 2;
            }
        }        
    }

}
