package edu.wz.cs.leetcode.hard;

import java.util.Arrays;

/**
 * 265. Paint House II<br/>
 * 
 * There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house 
 * with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same 
 * color.<br/>
 * 
 * The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] 
 * is the cost of painting house 0 with color 0; costs[1][2]is the cost of painting house 1 with color 2, and so on... 
 * Find the minimum cost to paint all houses.<br/>
 * 
 * Note: All costs are positive integers.<br/>
 * 
 * Follow up: Could you solve it in O(nk) runtime?
 */
public class PaintHouseII {
    
    public static int solution(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        
        // defensive copy of costs
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = costs[i][j];
            }
        }
        
        int min1 = -1;  // index of the smallest cost till previous house
        int min2 = -1;  // index of the 2nd smallest cost till previous house
        
        for (int i = 0; i < n; i++) {
            int last1 = min1;
            int last2 = min2;
            min1 = -1;
            min2 = -1;
            
            for (int j = 0; j < k; j++) {
                if (j != last1) {  // current color j is different from last min1
                    dp[i][j] += last1 < 0 ? 0 : dp[i-1][last1];
                }
                else {
                    dp[i][j] += last2 < 0 ? 0 : dp[i-1][last2];
                }
                
                // find the indices of 1st and 2nd smallest cost of painting current house i
                if (min1 < 0 || dp[i][j] < dp[i][min1]) {
                    min2 = min1;
                    min1 = j;
                }
                else if (min2 < 0 || dp[i][j] < dp[i][min2]) {
                    min2 = j;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n-1][min1];
    }
    
    public static void main(String[] args) {
        int[][] costs = {{1, 3, 4}, {2, 5, 6}};
        System.out.println(PaintHouseII.solution(costs));
    }

}
