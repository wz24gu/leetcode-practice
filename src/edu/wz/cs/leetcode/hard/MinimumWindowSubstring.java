package edu.wz.cs.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring<br>
 * https://leetcode.com/problems/minimum-window-substring<br><br>
 * 
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in 
 * complexity O(n).<br>
 * 
 * For example, S = "ADOBECODEBANC", T = "ABC", Minimum window is "BANC".<br>
 * 
 * Note: If there is no such window in S that covers all characters in T, return the empty string "".<br>
 * 
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
    
    public static String solution(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int n = s.length();
        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        int count = 0;
        
        for (int right = 0; right < n; right++) {
            char cRight = s.charAt(right);
            
            if (map.containsKey(cRight)) {
                map.put(cRight, map.get(cRight) - 1);
                if (map.get(cRight) >= 0) {
                    count++;
                }
                
                while (count == t.length()) {
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    char cLeft = s.charAt(left);
                    if (map.containsKey(cLeft)) {
                        map.put(cLeft, map.get(cLeft) + 1);
                        if (map.get(cLeft) > 0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        
        if (minLen > n) {
            return "";
        }
        return s.substring(minLeft, minLeft + minLen);
    }
    
    public static void main(String[] args) {
        System.out.println(MinimumWindowSubstring.solution("ADOBECODEBANC", "ABC"));
    }

}
