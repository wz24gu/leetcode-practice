package edu.wz.cs.leetcode.easy;

/**
 * 14. Longest Common Prefix<br>
 * https://leetcode.com/problems/longest-common-prefix<br><br>
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
    
    public static String solution(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        int n = strs.length;
        int m = strs[0].length();
        
        for (int i = 0; i < m; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String[] strings = {"abc", "ab", "abcde", "acc"};
        System.out.println(LongestCommonPrefix.solution(strings));
    }

}
