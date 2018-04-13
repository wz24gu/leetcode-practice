package edu.wz.cs.leetcode.easy;

/**
 * 70. Climbing Stairs<br>
 * https://leetcode.com/problems/climbing-stairs<br><br>
 * 
 * You are climbing a stair case. It takes n steps to reach to the top. Each time you can either climb 1 or 2 steps. In 
 * how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    
    // recursion TLE
    public static int solution(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        
        return solution(n - 1) + solution(n - 2);
    }
    
    public static int solutionAlt(int n) {
        if (n < 3) {
            return n;
        }
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        System.out.println(ClimbingStairs.solution(5));
        System.out.println(ClimbingStairs.solutionAlt(5));
    }

}
