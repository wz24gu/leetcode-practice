package edu.wz.cs.leetcode.easy;

/**
 * 746. Min Cost Climbing Stairs<br>
 * https://leetcode.com/problems/min-cost-climbing-stairs<br><br>
 * 
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).<br>
 * 
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the 
 * floor, and you can either start from the step with index 0, or the step with index 1.<br><br>
 * 
 * Note:<br>
 * 1. cost will have a length in the range [2, 1000].<br>
 * 2. Every cost[i] will be an integer in the range [0, 999].
 */
public class MinCostClimbingStairs {
    
    public static int solution(int[] cost) {
        int n = cost.length;
        if (n == 2) {
            return Math.min(cost[0], cost[1]);
        }
        
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
    
    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println(MinCostClimbingStairs.solution(cost));
        
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(MinCostClimbingStairs.solution(cost2));
    }

}
