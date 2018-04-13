package edu.wz.cs.leetcode.medium;

public class DesignTicTacToeX {

    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int anti_diagonal;
    private int N;
    
    public DesignTicTacToeX(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        anti_diagonal = 0;
        N = n;
    }
    
    public int move(int row, int col, int player) {
        int i = player == 1 ? 1 : -1;
        rows[row] += i;
        cols[col] += i;
        diagonal += (row == col ? i : 0);
        anti_diagonal += (row == N - col - 1 ? i : 0);
        
        if (Math.abs(rows[row]) == N || Math.abs(cols[col]) == N
                || Math.abs(diagonal) == N || Math.abs(anti_diagonal) == N) {
            return player;
        }
        else {
            return 0;
        }        
    }
    
}
