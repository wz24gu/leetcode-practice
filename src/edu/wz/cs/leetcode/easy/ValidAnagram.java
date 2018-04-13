package edu.wz.cs.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram<br>
 * https://leetcode.com/problems/valid-anagram<br><br>
 * 
 * Given two strings s and t, write a function to determine if t is an anagram of s.<br><br>
 * 
 * For example,<br>
 * s = "anagram", t = "nagaram", return true.<br>
 * s = "rat", t = "car", return false.<br>
 * 
 * Note: You may assume the string contains only lowercase alphabets.
 */
public class ValidAnagram {
    
    public static boolean solution(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        
        for (int f : freq) {
            if (f != 0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean solutionUnicode(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Integer> map = new HashMap<>();        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            else {
                map.put(c, map.get(c) - 1);
            }
        }
        
        for (int i : map.values()) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(ValidAnagram.solution("anagram", "nagaram"));
        System.out.println(ValidAnagram.solution("rat", "car"));
        
        System.out.println(ValidAnagram.solutionUnicode("anagram", "nagaram"));
        System.out.println(ValidAnagram.solutionUnicode("rat", "car"));
    }

}
