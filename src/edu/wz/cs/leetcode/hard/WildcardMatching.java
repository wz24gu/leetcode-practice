package edu.wz.cs.leetcode.hard;

/**
 * 44. Wildcard Matching<br>
 * https://leetcode.com/problems/wildcard-matching<br><br>
 * 
 * Implement wildcard pattern matching with support for '?' and '*'.<br>
 * 
 * '?' Matches any single character.<br>
 * '*' Matches any sequence of characters (including the empty sequence).<br>
 * 
 * The matching should cover the entire input string (not partial).
 */
public class WildcardMatching {
    
    public static boolean solution(String s, String p) {
        int sIdx = 0;
        int pIdx = 0;
        int match = -1;
        int starIdx = -1;
        
        int n = s.length();
        int m = p.length();
        
        while (sIdx < n) {
            if (pIdx < m && (p.charAt(pIdx) == '?' || s.charAt(sIdx) == p.charAt(pIdx))) {
                sIdx++;
                pIdx++;
            }
            else if (pIdx < m && p.charAt(pIdx) == '*') {
                starIdx = pIdx;
                match = sIdx;
                pIdx++;
            }
            else if (starIdx != -1) {
                pIdx = starIdx + 1;
                match++;
                sIdx = match;
            }
            else {
                return false;
            }
        }
        
        while (pIdx < m && p.charAt(pIdx) == '*') {
            pIdx++;
        }
        return pIdx == m;
    }
    
    public static void main(String[] args) {
        System.out.println(WildcardMatching.solution("aa", "a"));
        System.out.println(WildcardMatching.solution("aa", "aa"));
        System.out.println(WildcardMatching.solution("aaa", "aa"));
        System.out.println(WildcardMatching.solution("aa", "*"));
        System.out.println(WildcardMatching.solution("aa", "a*"));
        System.out.println(WildcardMatching.solution("ab", "?*"));
        System.out.println(WildcardMatching.solution("aab", "c*a*b"));
    }

}
