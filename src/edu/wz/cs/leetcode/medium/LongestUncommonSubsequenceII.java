package edu.wz.cs.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * 522. Longest Uncommon Subsequence II<br>
 * https://leetcode.com/problems/longest-uncommon-subsequence-ii<br><br>
 * 
 * Given a list of strings, you need to find the longest uncommon subsequence among them. The longest uncommon subsequence 
 * is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of 
 * the other strings.<br>
 * 
 * A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the 
 * order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence 
 * of any string.<br>
 * 
 * The input will be a list of strings, and the output needs to be the length of the longest uncommon subsequence. If 
 * the longest uncommon subsequence doesn't exist, return -1.<br>
 * 
 * Example 1: Input: "aba", "cdc", "eae"; Output: 3<br>
 * 
 * Note:<br>
 * 1. All the given strings' lengths will not exceed 10.<br>
 * 2. The length of the given list will be in the range of [2, 50].
 */
public class LongestUncommonSubsequenceII {
    
    public static int solution(String[] strs) {
        int result = -1;
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            int j;
            for (j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (helper(strs[i], strs[j])) {
                    break;
                }
            }
            if (j == n) {
                result = Math.max(result, strs[i].length());
            }
        }
        
        return result;        
    }
    
    private static boolean helper(String sub, String str) {
        int i = 0;
        for (char c : str.toCharArray()) {
            if (c == sub.charAt(i)) {
                i++;
            }
            if (i == sub.length()) {
                break;
            }
        }
        return i == sub.length();
    }
    
    public static int solutionX(String[] strs) {
        int n = strs.length;
        Set<String> set = new HashSet<>();
        
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String a, String b) {
                if (a.length() == b.length()) {
                    return a.compareTo(b);
                }
                else {
                    return a.length() - b.length();
                }
            }
        });
        
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || strs[i] != strs[i+1]) {
                boolean found = true;
                
                for (String s : set) {
                    int j = 0;
                    for (char c : s.toCharArray()) {
                        if (c == strs[i].charAt(j)) {
                            j++;
                        }
                        if (j == strs[i].length()) {
                            break;
                        }
                    }
                    if (j == strs[i].length()) {
                        found = false;
                        break;
                    }
                }
                
                if (found) {
                    return strs[i].length();
                }
            }
            
            set.add(strs[i]);  // shorter string can be substrings of longer string only
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        String[] strs = {"aba", "cdc", "eae"};
        System.out.println(LongestUncommonSubsequenceII.solution(strs));
        System.out.println(LongestUncommonSubsequenceII.solutionX(strs));
    }

}
