package edu.wz.cs.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 159. Longest Substring with At Most Two Distinct Characters<br/>
 * 
 * Given a string S, find the length of the longest substring T that contains at most two distinct characters.<br/>
 * 
 * For example, Given S = "eceba", T is “ece” which its length is 3.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    
    public static int solution(String s) {
        int result = 0;
        
        int n = s.length();
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
            
            while (map.size() > 2) {
                char l = s.charAt(left);
                if (map.get(l) == 1) {
                    map.remove(l);
                }
                else {
                    map.put(l, map.get(l) - 1);
                }
                left++;
            }
            
            result = Math.max(result, right - left + 1);
        }
        
        return result;        
    }
    
    public static int solutionAlt(String s) {
        int result = 0;
        int n = s.length();
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < n; right++) {
            map.put(s.charAt(right), right);
            while (map.size() > 2) {
                if (map.get(s.charAt(left)) == left) {
                    map.remove(s.charAt(left));
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(LongestSubstringWithAtMostTwoDistinctCharacters.solution("eceba"));
        System.out.println(LongestSubstringWithAtMostTwoDistinctCharacters.solutionAlt("eceba"));
    }

}
