package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 529. Mine Sweeper<br>
 * https://leetcode.com/problems/minesweeper<br><br>
 * 
 * Let's play the minesweeper game.<br>
 * 
 * You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an
 * unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right,
 * and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square,
 * and finally 'X' represents a revealed mine.<br>
 * 
 * Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the
 * board after revealing this position according to the following rules:<br>
 * 1. If a mine ('M') is revealed, then the game is over - change it to 'X'.<br>
 * 2. If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of
 * its adjacent unrevealed squares should be revealed recursively.<br>
 * 3. If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8')
 * representing the number of adjacent mines.
 * 4. Return the board when no more squares will be revealed.<br><br>
 * 
 * Note:<br>
 * 1. The range of the input matrix's height and width is [1,50].<br>
 * 2. The click position will only be an unrevealed square ('M' or 'E'), which also means the input board contains at
 * least one clickable square.<br>
 * 3. The input board won't be a stage when game is over (some mines have been revealed).<br>
 * 4. For simplicity, not mentioned rules should be ignored in this problem. For example, you don't need to reveal all
 * the unrevealed mines when the game is over, consider any cases that you will win the game or flag any squares.
 */
public class MineSweeper {
    
    public static char[][] solution(char[][] board, int[] click) {
        int R = board.length;
        int C = board[0].length;
        int r = click[0];
        int c = click[1];
        
        int[][] dirs = { {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1} };
        
        if (board[r][c] == 'M') {  // find the mine
            board[r][c] = 'X';
        }
        else {
            int count = 0;
            for (int[] dir : dirs) {
                int x = r + dir[0];
                int y = c + dir[1];
                if (x >= 0 && x < R && y >= 0 && y < C && board[x][y] == 'M') {
                    count++;
                }
            }
            
            if (count > 0) {  // there are mines in adjacent grid 
                board[r][c] = (char) (count + '0');
            }
            else {
                board[r][c] = 'B';
                for (int[] dir : dirs) {
                    int x = r + dir[0];
                    int y = c + dir[1];
                    if (x >= 0 && x < R && y >= 0 && y < C && board[x][y] == 'E') {
                        solution(board, new int[] {x, y});  // recursively click
                    }
                }
            }            
        }
        
        return board;
    }
    
    public static void main(String[] args) {
        char[][] board = { {'E', 'E', 'E', 'E', 'E'},
                           {'E', 'E', 'M', 'E', 'E'},
                           {'E', 'E', 'E', 'E', 'E'},
                           {'E', 'E', 'E', 'E', 'E'} };
        MineSweeper.solution(board, new int[] {3, 0});
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println();
        
        char[][] board2 = { {'B', '1', 'E', '1', 'B'},
                            {'B', '1', 'M', '1', 'B'},
                            {'B', '1', '1', '1', 'B'},
                            {'B', 'B', 'B', 'B', 'B'} };
        MineSweeper.solution(board2, new int[] {1, 2});
        for (int i = 0; i < board2.length; i++) {
         System.out.println(Arrays.toString(board2[i]));
        }        
    }

}
