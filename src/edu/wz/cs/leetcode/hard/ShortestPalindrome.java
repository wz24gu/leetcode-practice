package edu.wz.cs.leetcode.hard;

/**
 * 214. Shortest Palindrome<br>
 * https://leetcode.com/problems/shortest-palindrome<br><br>
 * 
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return 
 * the shortest palindrome you can find by performing this transformation.<br>
 * 
 * For example:<br>
 * Given "aacecaaa", return "aaacecaaa".<br>
 * Given "abcd", return "dcbabcd".
 */
public class ShortestPalindrome {
    
    public static String solution(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        String r = new StringBuilder(s).reverse().toString();
        String t = s + "#" + r;
        
        int n = t.length();
        int[] kmp = new int[n];
        int idx = 0;
        for (int i = 1; i < n; i++) {
            if (t.charAt(idx) == t.charAt(i)) {
                kmp[i] = kmp[i-1] + 1;
                idx++;
            }
            else {
                idx = kmp[i-1];
                while (idx > 0 && t.charAt(idx) != t.charAt(i)) {
                    idx = kmp[idx-1];
                }
                if (t.charAt(idx) == t.charAt(i)) {
                    idx++;
                }
                kmp[i] = idx;
            }
        }
        return r.substring(0, s.length() - kmp[t.length() - 1]) + s;
    }
    
    public static String solutionAlt(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        char[] arr = s.toCharArray();
        int i = 0;
        int n = arr.length - 1;
        int j = n;
        
        while (i < j) {
            if (arr[i] == arr[j]) {
                i++;
                j--;
            }
            else {
                i = 0;
                n--;
                j = n;
            }
        }
        
        return new StringBuilder(s.substring(n + 1)).reverse().toString() + s;
    }
    
    public static void main(String[] args) {
        System.out.println(ShortestPalindrome.solution("abac"));
        System.out.println(ShortestPalindrome.solutionAlt("abac"));
    }

}
