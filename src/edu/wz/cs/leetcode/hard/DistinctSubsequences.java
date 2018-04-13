package edu.wz.cs.leetcode.hard;

/**
 * 115. Distinct Subsequences<br>
 * https://leetcode.com/problems/distinct-subsequences<br><br>
 * 
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.<br>
 * 
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of 
 * the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of 
 * "ABCDE" while "AEC" is not).<br>
 * 
 * Here is an example: S = "rabbbit", T = "rabbit", Return 3.
 */
public class DistinctSubsequences {
    
    public static int solution(String s, String t) {
        int row = t.length();
        int col = s.length();
        int[][] dp = new int[row+1][col+1];
        
        // fill in the first row with 1
        for (int j = 0; j <= col; j++) {
            dp[0][j] = 1;
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (t.charAt(i) == s.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + dp[i+1][j];
                }
                else {
                    dp[i+1][j+1] = dp[i+1][j];
                }
            }
        }
        
        return dp[row][col];
    }
    
    public static void main(String[] args) {
        System.out.println(DistinctSubsequences.solution("rabbbit", "rabbit"));
    }

}
