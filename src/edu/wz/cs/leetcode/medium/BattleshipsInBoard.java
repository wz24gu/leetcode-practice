package edu.wz.cs.leetcode.medium;

/**
 * 419. Battleships in a Board<br>
 * https://leetcode.com/problems/battleships-in-a-board<br><br>
 * 
 * Given an 2D board, count how many different battleships are in it. The battleships are represented with 'X's, empty
 * slots are represented with '.'s. You may assume the following rules:<br>
 * 1. You receive a valid board, made of only battleships or empty slots.<br>
 * 2. Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN
 * (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.<br>
 * 3. At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 */
public class BattleshipsInBoard {
    
    public static int solution(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c == 'X'
                        && (i == 0 || board[i-1][j] != 'X')
                        && (j == 0 || board[i][j-1] != 'X')) {
                    sum++;
                }
            }
        }
        return sum;
    }
    
    public static void main(String[] args) {
        char[][] board = { {'X', '.', '.', 'X'},
                           {'.', '.', '.', 'X'},
                           {'.', '.', '.', 'X'}
                         };
        System.out.println(BattleshipsInBoard.solution(board));
    }

}
