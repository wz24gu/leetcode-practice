package edu.wz.cs.leetcode.hard;

/**
 * 730. Count Different Palindromic Subsequences<br>
 * https://leetcode.com/problems/count-different-palindromic-subsequences<br><br>
 * 
 * Given a string S, find the number of different non-empty palindromic subsequences in S, and return that number 
 * modulo 10^9 + 7.<br>
 * 
 * A subsequence of a string S is obtained by deleting 0 or more characters from S.<br>
 * 
 * A sequence is palindromic if it is equal to the sequence reversed.<br>
 * 
 * Two sequences A_1, A_2, ... and B_1, B_2, ... are different if there is some i for which A_i != B_i.<br><br>
 * 
 * Note:<br>
 * 1. The length of S will be in the range [1, 1000].<br>
 * 2. Each character S[i] will be in the set {'a', 'b', 'c', 'd'}.
 */
public class CountDifferentPalindromicSubsequences {
    
    public static int solution(String S) {
        int n = S.length();
        int M = 1000000007;
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (S.charAt(i) == S.charAt(j)) {
                    int left = i + 1;
                    int right = j - 1;
                    while (left <= right && S.charAt(left) != S.charAt(i)) {
                        left++;
                    }
                    while (left <= right && S.charAt(right) != S.charAt(i)) {
                        right--;
                    }
                    if (left > right) {
                        dp[i][j] = dp[i+1][j-1] * 2 + 2;
                    }
                    else if (left == right) {
                        dp[i][j] = dp[i+1][j-1] * 2 + 1;
                    }
                    else {
                        dp[i][j] = dp[i+1][j-1] * 2 - dp[left+1][right-1];
                    }
                }
                else {
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1]; 
                }
                dp[i][j] = (dp[i][j] < 0) ? dp[i][j] + M : dp[i][j] % M;
            }
        }
        
        return dp[0][n-1];
    }
    
    public static void main(String[] args) {
        System.out.println(CountDifferentPalindromicSubsequences.solution("bccb"));
        System.out.println(CountDifferentPalindromicSubsequences.solution("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"));
    }

}
