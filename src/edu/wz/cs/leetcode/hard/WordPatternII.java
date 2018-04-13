package edu.wz.cs.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 291. Word Pattern II<br/>
 * 
 * Given a pattern and a string str, find if str follows the same pattern.<br/>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring 
 * in str.<br/>
 * 
 * Examples:<br/>
 * 1. pattern = "abab", str = "redblueredblue" should return true.<br/>
 * 2. pattern = "aaaa", str = "asdasdasdasd" should return true.<br/>
 * 3. pattern = "aabb", str = "xyzabcxzyabc" should return false.<br/>
 * 
 * Notes: You may assume both pattern and str contains only lowercase letters.
 */
public class WordPatternII {
    
    public static boolean solution(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return helper(pattern, 0, str, 0, map, set);
    }
    
    private static boolean helper(String pattern, int i, String str, int j,
            Map<Character, String> map, Set<String> set) {
        if (i == pattern.length() && j == str.length()) {
            return true;
        }
        if (i == pattern.length() || j == str.length()) {
            return false;
        }
        
        char c = pattern.charAt(i);
        // pattern character in the map
        if (map.containsKey(c)) {
            String sub = map.get(c);
            if (!str.startsWith(sub, j)) {
                return false;
            }
            return helper(pattern, i + 1, str, j + sub.length(), map, set);
        }
        
        // pattern character not in the map
        for (int k = j; k < str.length(); k++) {
            String sub = str.substring(j, k + 1);
            if (set.contains(sub)) {
                continue;
            }
            
            map.put(c, sub);
            set.add(sub);
            if (helper(pattern, i + 1, str, k + 1, map, set)) {
                return true;
            }
            map.remove(c);
            set.remove(sub);            
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(WordPatternII.solution("abab", "redblueredblue"));
        System.out.println(WordPatternII.solution("aaaa", "asdasdasdasd"));
        System.out.println(WordPatternII.solution("aabb", "xyzabcxzyabc"));
    }

}
