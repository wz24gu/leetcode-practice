package edu.wz.cs.leetcode.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 727. Minimum Window Subsequence<br>
 * https://leetcode.com/problems/minimum-window-subsequence<br><br>
 * 
 * Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.<br>
 * 
 * If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple 
 * such minimum-length windows, return the one with the left-most starting index.<br>
 * 
 * Note:<br><br>
 * 1. All the strings in the input will only contain lowercase letters.<br>
 * 2. The length of S will be in the range [1, 20000].<br>
 * 3. The length of T will be in the range [1, 100].
 */
public class MinimumWindowSubsequence {
    
    public static String solution(String S, String T) {
        Map<Character, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char) (i + 'a'), new TreeSet<Integer>());
        }
        
        for (int i = 0; i < S.length(); i++) {
            map.get(S.charAt(i)).add(i);
        }
        
        int diff = Integer.MAX_VALUE;
        String res = "";
        for (int start : map.get(T.charAt(0))) {
            int end = getEnd(map, start - 1, T, 0);
            if (end != -1 && diff > end - start) {
                diff = end - start;
                res = S.substring(start, end + 1);
            }
        }
        return res;
    }
    
    private static int getEnd(Map<Character, TreeSet<Integer>> map, Integer prev, String T, int i) {
        Integer curr = map.get(T.charAt(i)).higher(prev);
        if (curr == null || curr == -1) {
            return -1;
        }
        if (i == T.length() - 1) {
            return curr;
        }
        return getEnd(map, curr, T, i + 1);
    }
    
    public static void main(String[] args) {
        System.out.println(MinimumWindowSubsequence.solution("abcdebdde", "bde"));
    }

}
