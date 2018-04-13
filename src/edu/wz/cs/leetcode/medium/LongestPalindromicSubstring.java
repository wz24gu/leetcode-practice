package edu.wz.cs.leetcode.medium;

/**
 * 5. Longest Palindromic Substring<br>
 * https://leetcode.com/problems/longest-palindromic-substring<br><br>
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */
public class LongestPalindromicSubstring {
    
    public static String solutionBruteForce(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        String result = "";
        int n = s.length();
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (isPalindrome(s, i, j)) {
                    if (len > result.length()) {
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }
        return result;
    }
    
    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    private static String res;
    private static int len;    
    public static String solutionX(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        res = "";
        len = 0;
        
        int n = s.length();
        for (int i = 0; i < n; i++) {
            extend(s, i, i, n);
            extend(s, i, i + 1, n);
        }
        return res; 
    }
    
    private static void extend(String s, int i, int j, int n) {
        while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (j - i - 1 > len) {
            len = j - i - 1;
            res = s.substring(i + 1, j);
        }
    }
    
    private static String solutionDP(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        String result = "";
        int max = 0;
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j || i + 1 == j || dp[i+1][j-1]) {
                        dp[i][j] = true;
                        if (j - i + 1 > max) {
                            max = j - i + 1;
                            result = s.substring(i, j + 1);
                        }
                    }
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(LongestPalindromicSubstring.solutionBruteForce("babad"));
        System.out.println(LongestPalindromicSubstring.solutionBruteForce("cbbd"));
        
        System.out.println(LongestPalindromicSubstring.solutionX("babad"));
        System.out.println(LongestPalindromicSubstring.solutionX("cbbd"));
        
        System.out.println(LongestPalindromicSubstring.solutionDP("babad"));
        System.out.println(LongestPalindromicSubstring.solutionDP("cbbd"));
    }

}
