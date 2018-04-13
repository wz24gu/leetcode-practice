package edu.wz.cs.leetcode.algorithm;

public class Substring {

    public int bruteforce(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();
        if (m > n) {
            return -1;
        }
        if (m == 0) {
            return 0;
        }
        
        // double loop
        for (int i = 0; i < n - m + 1; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }
    
    public int KMP(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();
        if (m > n) {
            return -1;
        }
        if (m == 0) {
            return 0;
        }
        
        int[][] dfa = new int[256][m];  // extended ASCII
        dfa[needle.charAt(0)][0] = 1;
        int prev = 0;
        for (int j = 1; j < m; j++) {
            for (int c = 0; c < 256; c++) {
                dfa[c][j] = dfa[c][prev];
            }
            dfa[needle.charAt(j)][j] = j + 1;
            prev = dfa[needle.charAt(j)][prev];
        }
        
        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            j = dfa[haystack.charAt(i)][j];
        }
        if (j == m) {
            return i - m;
        }
        else {
            return -1;
        }        
    }
    
    public static void main(String[] args) {
        Substring substring = new Substring();
        System.out.println(substring.bruteforce("hello", "ll"));
        System.out.println(substring.bruteforce("hello", "ab"));
        
        System.out.println(substring.KMP("hello", "ll"));
        System.out.println(substring.KMP("hello", "ab"));
    }
    
}
