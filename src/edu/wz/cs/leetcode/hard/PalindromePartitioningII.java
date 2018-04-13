package edu.wz.cs.leetcode.hard;

/**
 * 132. Palindrome Partitioning II<br>
 * https://leetcode.com/problems/palindrome-partitioning-ii<br><br>
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.<br>
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.<br>
 * 
 * For example, given s = "aab",<br>
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioningII {
    
    public static int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int n = s.length();
        boolean[][] p = new boolean[n][n];
        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++) {
            dp[i] = i;  // worst case i cuts
            p[i][i] = true;  // one char string is always a palindrome
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || p[j+1][i-1])) {
                    if (j == 0) {
                        dp[i] = 0;
                    }
                    else {
                        p[j][i] = true;
                        dp[i] = Math.min(dp[j-1] + 1, dp[i]);
                    }
                }
            }
        }
        
        return dp[n-1];
    }
    
    public static void main(String[] args) {
        System.out.println(PalindromePartitioningII.solution("aab"));
    }

}
