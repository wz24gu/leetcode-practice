package edu.wz.cs.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. Valid Sudoku<br>
 * https://leetcode.com/problems/valid-sudoku<br><br>
 * 
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules. The Sudoku board could be partially 
 * filled, where empty cells are filled with the character '.'.<br>
 * 
 * Note: A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be 
 * validated.
 */
public class ValidSudoku {
    
    public static boolean solution(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        
        for (int i = 0; i < 9; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> cols = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            
            for (int j = 0; j < 9; j++) {
                // check the row
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }
                // check the column
                if (board[j][i] != '.' && !cols.add(board[j][i])) {
                    return false;
                }
                
                // check the cube, tricky
                int rowStart = 3 * (i / 3);
                int colStart = 3 * (i % 3);
                int r = rowStart + j / 3;
                int c = colStart + j % 3;
                if (board[r][c] != '.' && !cube.add(board[r][c])) {
                    return false;
                }
            }
        }
        
        return true;
    }

}
