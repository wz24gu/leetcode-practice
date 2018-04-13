package edu.wz.cs.leetcode.easy;

/**
 * 256. Paint House<br>
 * https://leetcode.com/problems/paint-house<br><br>
 * 
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of 
 * painting each house with a certain color is different. You have to paint all the houses such that no two adjacent 
 * houses have the same color.<br>
 * 
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] 
 * is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so 
 * on... Find the minimum cost to paint all houses.<br>
 * 
 * Note: All costs are positive integers.
 */
public class PaintHouse {
    
    public static int solution(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        
        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = new int[m][n];
        
        // set the first house
        for (int j = 0; j < n; j++) {
            dp[0][j] = costs[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = costs[i][j] + Math.min(dp[i-1][(j + 1) % 3], dp[i-1][(j + 2) % 3]);  // nice trick
            }
        }
        
        return Math.min(dp[m-1][0], Math.min(dp[m-1][1], dp[m-1][2]));
    }

}
