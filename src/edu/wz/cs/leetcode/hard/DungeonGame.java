package edu.wz.cs.leetcode.hard;

/**
 * 174. Dungeon Game<br>
 * https://leetcode.com/problems/dungeon-game<br><br>
 * 
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon 
 * consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room 
 * and must fight his way through the dungeon to rescue the princess.<br>
 * 
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 
 * or below, he dies immediately.<br>
 * 
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; 
 * other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).<br>
 * 
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.<br>
 * 
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.<br><br>
 * 
 * Notes:<br>
 * 1. The knight's health has no upper bound.<br>
 * 2. Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where 
 * the princess is imprisoned.
 */
public class DungeonGame {
    
    public static int solution(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = Math.max(1, 1 - dungeon[m-1][n-1]);
        
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n-1] = Math.max(1, dp[i+1][n-1] - dungeon[i][n-1]);
        }
        for (int j = n - 2; j >= 0; j--) {
            dp[m-1][j] = Math.max(1, dp[m-1][j+1] - dungeon[m-1][j]);
        }
        
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]);
            }
        }
        
        return dp[0][0];
    }
    
    public static void main(String[] args) {
        int[][] dungeon = { {-2, -3, 3},
                            {-5, -10, 1},
                            {10, 30, -5} };
        System.out.println(DungeonGame.solution(dungeon));
    }

}
