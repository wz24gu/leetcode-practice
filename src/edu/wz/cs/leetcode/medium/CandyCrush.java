package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 723. Candy Crush<br>
 * https://leetcode.com/problems/candy-crush<br><br>
 * 
 * This question is about implementing a basic elimination algorithm for Candy Crush.<br>
 * 
 * Given a 2D integer array board representing the grid of candy, different positive integers board[i][j] represent 
 * different types of candies. A value of board[i][j] = 0 represents that the cell at position (i, j) is empty. 
 * The given board represents the state of the game following the player's move. Now, you need to restore the board to 
 * a stable state by crushing candies according to the following rules:<br>
 * 
 * 1. If three or more candies of the same type are adjacent vertically or horizontally, "crush" them all at the same 
 * time - these positions become empty.<br>
 * 2. After crushing all candies simultaneously, if an empty space on the board has candies on top of itself, then these 
 * candies will drop until they hit a candy or bottom at the same time. (No new candies will drop outside the top boundary.)<br>
 * 3. After the above steps, there may exist more candies that can be crushed. If so, you need to repeat the above steps.<br>
 * 4. If there does not exist more candies that can be crushed (ie. the board is stable), then return the current board.<br>
 * 
 * You need to perform the above rules until the board becomes stable, then return the current board.<br><br>
 * 
 * Note:<br>
 * 1. The length of board will be in the range [3, 50].<br>
 * 2. The length of board[i] will be in the range [3, 50].<br>
 * 3. Each board[i][j] will initially start as an integer in the range [1, 2000].
 */
public class CandyCrush {

    public static int[][] solution(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        while (true) {
            List<int[]> delete = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 0) {
                        continue;
                    }
                    
                    int left = i;
                    int right = i;
                    int up = j;
                    int down = j;
                    while (left >= 0 && left > i - 3 && board[left][j] == board[i][j]) {
                        left--;
                    }
                    while (right < m && right < i + 3 && board[right][j] == board[i][j]) {
                        right++;
                    }
                    while (up >= 0 && up > j - 3 && board[i][up] == board[i][j]) {
                        up--;
                    }
                    while (down < n && down < j + 3 && board[i][down] == board[i][j]) {
                        down++;
                    }
                    if (right - left > 3 || down - up > 3) {
                        delete.add(new int[] {i, j});
                    }
                }
            }
            
            if (delete.isEmpty()) {
                break;
            }
            
            for (int[] del : delete) {
                board[del[0]][del[1]] = 0;
            }
            
            for (int j = 0; j < n; j++) {
                int t = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (board[i][j] != 0) {
                        int tmp = board[i][j];
                        board[i][j] = board[t][j];
                        board[t][j] = tmp;
                        t--;
                    }
                }
            }
        }
        
        return board;
    }
    
    public static void main(String[] args) {
        int[][] board = { {110, 5, 112, 113, 114},
                          {210, 211, 5, 213, 214},
                          {310, 311, 3, 313, 314},
                          {410, 411, 412, 5, 414},
                          {5, 1, 512, 3, 3},
                          {610, 4, 1, 613, 614},
                          {710, 1, 2, 713, 714},
                          {810, 1, 2, 1, 1},
                          {1, 1, 2, 2, 2},
                          {4, 1, 4, 4, 1014} };
        int[][] newboard = CandyCrush.solution(board);
        for (int i = 0; i < newboard.length; i++) {
            System.out.println(Arrays.toString(newboard[i]));
        }
    }

}
