package edu.wz.cs.leetcode.medium;

/**
 * 712. Minimum ASCII Delete Sum for Two Strings<br>
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings<br><br>
 * 
 * Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.<br><br>
 * 
 * Note:<br>
 * 1. 0 < s1.length, s2.length <= 1000.<br>
 * 2. All elements of each string will have an ASCII value in [97, 122].
 */
public class MinimumASCIIDeleteSumForTwoStrings {
    
    public static int solution(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }
        for (int i = 1; i <= n2; i++) {
            dp[0][i] = dp[0][i-1] + s2.charAt(i-1);
        }
        
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j] + s1.charAt(i-1), dp[i][j-1] + s2.charAt(j-1));
                }                
            }
        }
        
        return dp[n1][n2];
    }
    
    public static void main(String[] args) {
        System.out.println(MinimumASCIIDeleteSumForTwoStrings.solution("sea", "eat"));
        System.out.println(MinimumASCIIDeleteSumForTwoStrings.solution("delete", "leet"));
    }

}
