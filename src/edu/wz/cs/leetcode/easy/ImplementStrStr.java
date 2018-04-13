package edu.wz.cs.leetcode.easy;

/**
 * 28. Implement strStr()<br>
 * https://leetcode.com/problems/implement-strstr<br><br>
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class ImplementStrStr {
    
    public static int solution(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m > n) {
            return -1;
        }
        if (m == 0) {
            return 0;
        }
        
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;  // tricky, cannot return -1 here
                }
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }
    
    // implemented with KMP
    public static int solutionKMP(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m > n) {
            return -1;
        }
        if (m == 0) {
            return 0;
        }
        
        int[][] dfa = new int[128][m];  // use basic ASCII
        dfa[needle.charAt(0)][0] = 1;  // first character of needle
        int x = 0;  // previous status
        for (int j = 1; j < m; j++) {
            for (int c = 0; c < 128; c++) {
                dfa[c][j] = dfa[c][x];  // copy from previous status
            }
            dfa[needle.charAt(j)][j] = j + 1;  // matching character move 1 step
            x = dfa[needle.charAt(j)][x];
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
        System.out.println(ImplementStrStr.solution("this is a book", "book"));
        System.out.println(ImplementStrStr.solutionKMP("this is a book", "book"));
    }

}
