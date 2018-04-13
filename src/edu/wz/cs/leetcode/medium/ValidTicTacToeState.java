package edu.wz.cs.leetcode.medium;

/**
 * 794. Valid Tic-Tac-Toe State<br>
 * https://leetcode.com/problems/valid-tic-tac-toe-state<br><br>
 * 
 * A Tic-Tac-Toe board is given as a string array board. Return True if and only if it is possible to reach this board 
 * position during the course of a valid tic-tac-toe game.<br>
 * 
 * The board is a 3 x 3 array, and consists of characters " ", "X", and "O".  The " " character represents an empty square.<br>
 * 
 * Here are the rules of Tic-Tac-Toe:<br>
 * 1. Players take turns placing characters into empty squares (" ").<br>
 * 2. The first player always places "X" characters, while the second player always places "O" characters.<br>
 * 3. "X" and "O" characters are always placed into empty squares, never filled ones.<br>
 * 4. The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.<br>
 * 5. The game also ends if all squares are non-empty.<br>
 * 6. No more moves can be played if the game is over.<br><br>
 * 
 * Note:<br>
 * 1. board is a length-3 array of strings, where each string board[i] has length 3.<br>
 * 2. Each board[i][j] is a character in the set {" ", "X", "O"}.
 */
public class ValidTicTacToeState {
    
    public static boolean solution(String[] board) {
        int countX = 0;
        int countO = 0;
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X') {
                    countX++;
                }
                if (c == 'O') {
                    countO++;
                }
            }
        }
        
        if (countX < countO || countX > countO + 1) {
            return false;
        }
        if (check(board, 'X') && countX - countO != 1) {
            return false;
        }
        if (check(board, 'O') && countX != countO) {
            return false;
        }
        return true;
    }
    
    private static boolean check(String[] board, char c) {
        // diagonal
        if (board[1].charAt(1) == c) {
            if (board[0].charAt(0) == c && board[2].charAt(2) == c) {
                return true;
            }
            if (board[0].charAt(2) == c && board[2].charAt(0) == c) {
                return true;
            }
        }
        // vertical
        for (int j = 0; j < 3; j++) {
            if (board[0].charAt(j) == c) {
                if (board[1].charAt(j) == c && board[2].charAt(j) == c) {
                    return true;
                }
            }
        }
        // horizontal
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == c) {
                if (board[i].charAt(1) == c && board[i].charAt(2) == c) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        String[] board = {"O  ", "   ", "   "};
        System.out.println(ValidTicTacToeState.solution(board));
        
        String[] board2 = {"XOX", " X ", "   "};
        System.out.println(ValidTicTacToeState.solution(board2));
        
        String[] board3 = {"XXX", "   ", "OOO"};
        System.out.println(ValidTicTacToeState.solution(board3));
        
        String[] board4 = {"XOX", "O O", "XOX"};
        System.out.println(ValidTicTacToeState.solution(board4));
    }

}
