package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 688. Knight Probability in Chessboard<br>
 * https://leetcode.com/problems/knight-probability-in-chessboard<br><br>
 * 
 * On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves. The rows 
 * and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).<br>
 * 
 * A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal 
 * direction, then one square in an orthogonal direction.<br>
 * 
 * Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would 
 * go off the chessboard) and moves there.<br>
 * 
 * The knight continues moving until it has made exactly K moves or has moved off the chessboard. Return the probability 
 * that the knight remains on the board after it has stopped moving.<br><br>
 * 
 * Note:<br>
 * 1. N will be between 1 and 25.<br>
 * 2. K will be between 0 and 100.<br>
 * 2. The knight always initially starts on the board.
 */
public class KnightProbabilityInChessboard {
    
    public static double solution(int N, int K, int r, int c) {
        if (K == 0) {
            return 1;
        }
        
        int[][] dirs = { {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2} };
        
        double[][] dp = new double[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], 1);
        }
        
        for (int k = 0; k < K; k++) {
            double[][] tmp = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < 0 || x >= N || y < 0 || y >= N) {
                            continue;
                        }
                        tmp[i][j] += dp[x][y];
                    }
                }
            }
            dp = tmp;
        }
        
        return dp[r][c] / Math.pow(8, K);
    }
    
    public static void main(String[] args) {
        System.out.println(KnightProbabilityInChessboard.solution(3, 2, 0, 0));
    }

}
