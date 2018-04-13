package edu.wz.cs.leetcode.hard;

/**
 * 664. Strange Printer<br/> * 
 * https://leetcode.com/problems/strange-printer<br/><br/>
 * 
 * There is a strange printer with the following two special requirements:<br/>
 * 1. The printer can only print a sequence of the same character each time.<br/>
 * 2. At each turn, the printer can print new characters starting from and ending at any places, and will cover the 
 * original existing characters.<br/>
 * 
 * Given a string consists of lower English letters only, your job is to count the minimum number of turns the printer 
 * needed in order to print it.<br/>
 * 
 * Hint: Length of the given string will not exceed 100.
 */
public class StrangePrinter {
    
    public static int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;  // we need 1 turn for a single character
        }
        
        for (int len = 1; len < n; len++) {
            for (int left = 0; left + len < n; left++) {
                int right = left + len;
                dp[left][right] = len + 1;  // need one more turn to print additional character
                for (int k = left; k < right; k++) {
                    int step = dp[left][k] + dp[k+1][right];
                    if (s.charAt(k) == s.charAt(right)) {
                        step--;
                    }
                    dp[left][right] = Math.min(dp[left][right], step);
                }
            }
        }
        
        return dp[0][n-1];
    }
    
    public static void main(String[] args) {
        System.out.println(StrangePrinter.solution("aaabbb"));
        System.out.println(StrangePrinter.solution("aba"));
    }

}
