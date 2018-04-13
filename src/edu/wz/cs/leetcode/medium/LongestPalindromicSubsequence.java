package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 516. Longest Palindromic Subsequence<br>
 * https://leetcode.com/problems/longest-palindromic-subsequence<br><br>
 * 
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of 
 * s is 1000.
 */
public class LongestPalindromicSubsequence {
    
    public static int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;  // len = 1
        }
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (len == 2) ? 2 : dp[i+1][j-1] + 2;  // handle special case of len = 2, because i+1 > j-1
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        
        return dp[0][n-1];
    }
    
    public static void main(String[] args) {
        System.out.println(LongestPalindromicSubsequence.solution("bbbab"));
        System.out.println(LongestPalindromicSubsequence.solution("cbbd"));
    }

}
