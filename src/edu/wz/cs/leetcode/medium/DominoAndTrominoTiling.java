package edu.wz.cs.leetcode.medium;

/**
 * 790. Domino and Tromino Tiling<br>
 * https://leetcode.com/problems/domino-and-tromino-tiling<br><br>
 * 
 * We have two types of tiles: a 2x1 domino shape, and an "L" tromino shape. These shapes may be rotated.<br>
 * 
 * Given N, how many ways are there to tile a 2 x N board? Return your answer modulo 10^9 + 7.<br>
 * 
 * (In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 
 * 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.)<br>
 * 
 * Note: N  will be in range [1, 1000].
 */
public class DominoAndTrominoTiling {
    
    public static int solution(int N) {
        int mod = 1000000007;
        int[] dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= N; i++) {
            dp[i] = 2 * dp[i-1] + dp[i-3];
            dp[i] %= mod;
        }
        
        return dp[N];
    }
    
    public static void main(String[] args) {
        System.out.println(DominoAndTrominoTiling.solution(3));
    }

}
