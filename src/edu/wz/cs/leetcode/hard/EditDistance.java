package edu.wz.cs.leetcode.hard;

/**
 * 72. Edit Distance<br>
 * https://leetcode.com/problems/edit-distance<br><br>
 * 
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
 * (each operation is counted as 1 step.)<br>
 * 
 * You have the following 3 operations permitted on a word:<br>
 * a) Insert a character<br>
 * b) Delete a character<br>
 * c) Replace a character
 */
public class EditDistance {
    
    public static int solution(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        
        int[][] dp = new int[n1+1][n2+1];
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n2; i++) {
            dp[0][i] = i;
        }
        
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        
        return dp[n1][n2];
    }
    
    public static void main(String[] args) {
        System.out.println(EditDistance.solution("abcd", "bbc"));
    }

}
