package edu.wz.cs.leetcode.hard;

import java.util.Arrays;

/**
 * 87. Scramble String<br>
 * https://leetcode.com/problems/scramble-string<br><br>
 * 
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.<br>
 * 
 * To scramble the string, we may choose any non-leaf node and swap its two children.<br>
 * 
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".<br>
 * 
 * We say that "rgeat" is a scrambled string of "great".<br>
 * 
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".<br>
 * 
 * We say that "rgtae" is a scrambled string of "great".<br>
 * 
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */
public class ScrambleString {
    
    public static boolean solution(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        
        int m = s1.length();
        int n = s2.length();
        if (m != n) {
            return false;
        }
        
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < n; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        
        for (int i = 1; i < m; i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);
            if (solution(s11, s21) && solution(s12, s22)) {
                return true;
            }
            
            // cut from back
            s21 = s2.substring(m - i);
            s22 = s2.substring(0, m - i);
            if (solution(s11, s21) && solution(s12, s22)) {
                return true;
            }            
        }
        
        return false;
    }
    
    // TODO: can also implemented with dp
    
    public static void main(String[] args) {
        System.out.println(ScrambleString.solution("great", "rgeat"));
    }

}
