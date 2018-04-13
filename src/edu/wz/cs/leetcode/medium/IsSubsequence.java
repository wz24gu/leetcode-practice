package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 392. Is Subsequence<br>
 * https://leetcode.com/problems/is-subsequence<br><br>
 * 
 * Given a string s and a string t, check if s is subsequence of t.<br>
 * 
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long 
 * (length ~= 500,000) string, and s is a short string (<=100).<br>
 * 
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of 
 * the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of 
 * "abcde" while "aec" is not).<br>
 * 
 * Follow up:<br>
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T 
 * has its subsequence. In this scenario, how would you change your code?
 */
public class IsSubsequence {
    
    public static boolean solution(String s, String t) {
        if (s.length() == 0 || s.equals(t)) {
            return true;
        }
        
        int i = 0, m = s.length();
        int j = 0, n = t.length();
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            else {
                j++;
            }
        }
        return i == m;
    }
    
    public static boolean solutionBinarySeach(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        
        Map<Character, List<Integer>> map = new HashMap<>();
        int n = t.length();
        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<Integer>());
            }
            map.get(c).add(i);
        }
        
        int m = s.length();
        int prev = -1;
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);            
            if (!map.containsKey(c)) {
                return false;
            }
            
            List<Integer> list = map.get(c);
            prev = search(prev, list, 0, list.size() - 1);
            if (prev == -1) {
                return false;
            }
            prev++;
        }
        
        return true;        
    }
    
    private static int search(int idx, List<Integer> list, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) < idx) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return lo == list.size() ? -1 : list.get(lo);
    }
    
    public static void main(String[] args) {
        System.out.println(IsSubsequence.solution("abc", "ahbgdc"));
        System.out.println(IsSubsequence.solution("axc", "ahbgdc"));
        
        System.out.println(IsSubsequence.solutionBinarySeach("abc", "ahbgdc"));
        System.out.println(IsSubsequence.solutionBinarySeach("axc", "ahbgdc"));
    }

}
