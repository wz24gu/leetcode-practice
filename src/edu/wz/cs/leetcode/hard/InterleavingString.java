package edu.wz.cs.leetcode.hard;

/**
 * 97. Interleaving String<br>
 * https://leetcode.com/problems/interleaving-string<br><br>
 * 
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.<br>
 * 
 * For example, Given: s1 = "aabcc", s2 = "dbbca",<br>
 * When s3 = "aadbbcbcac", return true.<br>
 * When s3 = "aadbbbaccc", return false.
 */
public class InterleavingString {
    
    public static boolean solution(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        int n1 = s1.length();
        int n2 = s2.length();
        boolean[][] dp = new boolean[n1+1][n2+1];
        
        dp[0][0] = true;
        // first column: s1
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        // first column: s2
        for (int j = 1; j <= n2; j++) {
            dp[0][j] = dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
        }
        
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                dp[i][j] = (dp[i-1][j] && s1.charAt(i - 1) == s3.charAt(i - 1 + j))
                    || (dp[i][j-1] && s2.charAt(j - 1) == s3.charAt(j - 1 + i));
            }
        }
        
        return dp[n1][n2];        
    }
    
    public static void main(String[] args) {
        System.out.println(InterleavingString.solution("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(InterleavingString.solution("aabcc", "dbbca", "aadbbbaccc"));
    }

}
