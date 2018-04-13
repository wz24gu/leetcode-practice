package edu.wz.cs.leetcode.medium;

/**
 * 583. Delete Operation for Two Strings<br>
 * https://leetcode.com/problems/delete-operation-for-two-strings<br><br>
 * 
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where 
 * in each step you can delete one character in either string.<br><br>
 * 
 * Note:<br>
 * 1. The length of given words won't exceed 500.<br>
 * 2. Characters in given words can only be lower-case letters.
 */
public class DeleteOperationForTwoStrings {
    
    public static int solution(String word1, String word2) {
        // this problem can be reduced to longest common subsequence of two strings
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return m + n - 2 * dp[m][n];
    }
    
    public static void main(String[] args) {
        System.out.println(DeleteOperationForTwoStrings.solution("sea", "eat"));
    }

}
