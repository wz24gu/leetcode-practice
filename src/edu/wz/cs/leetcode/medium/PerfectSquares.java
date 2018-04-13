package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 279. Perfect Squares<br>
 * https://leetcode.com/problems/perfect-squares<br><br>
 * 
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which 
 * sum to n.<br>
 * 
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class PerfectSquares {
    
    public static int solution(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 0; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }
        
        return dp[n];
    }
    
    public static int solutionX(int n) {
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }
        
        for (int i = 1; i * i <= n; i++) {
            int j = (int) Math.sqrt(n - i * i);
            if (i * i + j * j == n) {
                return 2;
            }
        }
        return 3;
    }
    
    public static void main(String[] args) {
        System.out.println(PerfectSquares.solution(12));
        System.out.println(PerfectSquares.solution(13));
        
        System.out.println(PerfectSquares.solutionX(12));
        System.out.println(PerfectSquares.solutionX(13));
    }

}
