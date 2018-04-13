package edu.wz.cs.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 773. Sliding Puzzle<br>
 * https://leetcode.com/problems/sliding-puzzle<br><br>
 * 
 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.<br>
 * 
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.<br>
 * 
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].<br>
 * 
 * Given a puzzle board, return the least number of moves required so that the state of the board is solved. If it is 
 * impossible for the state of the board to be solved, return -1.<br><br>
 * 
 * Note:<br>
 * 1. board will be a 2 x 3 array as described above.<br>
 * 2. board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5].
 */
public class SlidingPuzzle {
    
    private static final int[][] dirs = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    private static int min;    
    
    public static int solution(int[][] board) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(123450, 0);
        min = Integer.MAX_VALUE;
        
        int[] zero = new int[2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    zero[0] = i;
                    zero[1] = j;
                    break;
                }
            }
        }
        
        helper(board, zero[0], zero[1], 0, map);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    private static void helper(int[][] board, int i, int j, int move, Map<Integer, Integer> map) {
        if (move > min) {
            return;
        }
        
        int num = toNumber(board);
        if (num == 123450) {
            min = move;
            return;
        }
        
        if (map.containsKey(num)) {
            if (move > map.get(num)) {
                return;
            }
        }
        
        map.put(num, move);
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < 2 && y >= 0 && y < 3) {
                swap(board, i, j, x, y);
                helper(board, x, y, move + 1, map);
                swap(board, x, y, i, j);
            }
        }
    }
    
    private static void swap(int[][] board, int i1, int j1, int i2, int j2) {
        int tmp = board[i1][j1];
        board[i1][j1] = board[i2][j2];
        board[i2][j2] = tmp;        
    }
    
    private static int toNumber(int[][] board) {
        int num = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                num = num * 10 + board[i][j];
            }
        }
        return num;
    }
    
    public static void main(String[] args) {
        int[][] board = { {1, 2, 3}, {4, 0, 5} };
        System.out.println(SlidingPuzzle.solution(board));
        
        int[][] board2 = { {1, 2, 3}, {5, 4, 0} };
        System.out.println(SlidingPuzzle.solution(board2));
        
        int[][] board3 = { {4, 1, 2}, {5, 0, 3} };
        System.out.println(SlidingPuzzle.solution(board3));
        
        int[][] board4 = { {3, 2, 4}, {1, 5, 0} };
        System.out.println(SlidingPuzzle.solution(board4));
    }

}
