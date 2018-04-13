package edu.wz.cs.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Palindrome Partition Recursion Backtrack Template
 */
public class PalindromePartition {
    
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        
        List<String> list = new ArrayList<>();
        backtrack(s, 0, list, result);
        return result;
    }
    
    private void backtrack(String s, int start, List<String> list, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<String>(list));
        }
        else {
            for (int i = start; i < s.length(); i++) {
                if (palindrome(s, start, i)) {
                    list.add(s.substring(start, i + 1));
                    backtrack(s, i + 1, list, result);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
    
    private boolean palindrome(String s, int i, int j) {
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
        PalindromePartition partition = new PalindromePartition();
        System.out.println(partition.partition("aab"));
    }

}
