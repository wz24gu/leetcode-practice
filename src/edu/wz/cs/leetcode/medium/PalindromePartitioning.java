package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning<br>
 * https://leetcode.com/problems/palindrome-partitioning<br><br>
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.<br>
 * 
 * Return all possible palindrome partitioning of s.
 */
public class PalindromePartitioning {
    
    public static List<List<String>> solution(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        
        List<String> list = new ArrayList<>();
        backtrack(s, 0, list, result);
        return result;
    }
    
    private static void backtrack(String s, int start, List<String> list, List<List<String>> result) {
        int n = s.length();
        if (start == n) {
            result.add(new ArrayList<String>(list));
            return;
        }
        
        for (int i = start; i < n; i++) {
            if (palindrome(s, start, i)) {
                list.add(s.substring(start, i + 1));
                backtrack(s, i + 1, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private static boolean palindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(PalindromePartitioning.solution("aab"));
    }

}
