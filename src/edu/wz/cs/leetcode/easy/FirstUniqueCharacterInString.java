package edu.wz.cs.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String<br>
 * https://leetcode.com/problems/first-unique-character-in-a-string<br><br>
 * 
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.<br>
 * 
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInString {
    
    public static int solution(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, n);
            }
            else {
                map.put(c, i);
            }
        }
        
        int result = n;
        for (int pos : map.values()) {           
            result = Math.min(result, pos);
        }
        return result == n ? -1 : result;
    }
    
    public static int solutionAlt(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (int i = 0; i < n; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(FirstUniqueCharacterInString.solution("leetcode"));
        System.out.println(FirstUniqueCharacterInString.solution("loveleetcode"));
        
        System.out.println(FirstUniqueCharacterInString.solutionAlt("leetcode"));
        System.out.println(FirstUniqueCharacterInString.solutionAlt("loveleetcode"));
    }

}
