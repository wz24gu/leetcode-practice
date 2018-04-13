package edu.wz.cs.leetcode.medium;

/**
 * 647. Palindromic Substrings<br>
 * https://leetcode.com/problems/palindromic-substrings<br><br>
 * 
 * Given a string, your task is to count how many palindromic substrings in this string. The substrings with different
 * start indexes or end indexes are counted as different substrings even they consist of same characters.<br><br>
 * 
 * Note: The input string length won't exceed 1000.
 */
public class PalindromicSubstrings {
    
    public static int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int count = 0;
        int n = s.length();
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                if (valid(s, i, i + len - 1)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private static boolean valid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    private static int count;
    
    public static int solutionX(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            extend(s, i, i, n);
            extend(s, i, i + 1, n);
        }
        return count;
    }
    
    private static void extend(String s, int i, int j, int n) {
        while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            count++;
        }
    }
    
    public static int solutionDp(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int count = 0;        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;  // len = 1
        }
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j || i + 1 == j || dp[i+1][j-1]) {
                        count++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(PalindromicSubstrings.solution("abc"));
        System.out.println(PalindromicSubstrings.solution("aaa"));
        
        System.out.println(PalindromicSubstrings.solutionX("abc"));
        System.out.println(PalindromicSubstrings.solutionX("aaa"));
        
        System.out.println(PalindromicSubstrings.solutionDp("abc"));
        System.out.println(PalindromicSubstrings.solutionDp("aaa"));
    }

}
