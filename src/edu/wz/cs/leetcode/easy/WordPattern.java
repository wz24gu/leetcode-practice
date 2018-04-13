package edu.wz.cs.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern<br>
 * https://leetcode.com/problems/word-pattern<br><br>
 * 
 * Given a pattern and a string str, find if str follows the same pattern.<br>
 * 
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.<br><br>
 * 
 * Examples:<br>
 * pattern = "abba", str = "dog cat cat dog" should return true.<br>
 * pattern = "abba", str = "dog cat cat fish" should return false.<br>
 * pattern = "aaaa", str = "dog cat cat dog" should return false.<br>
 * pattern = "abba", str = "dog dog dog dog" should return false.<br>
 * 
 * Notes: You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a 
 * single space.
 */
public class WordPattern {
    
    public static boolean solution(String pattern, String str) {        
        String[] words = str.split(" ");
        
        int m = pattern.length();
        int n = words.length;
        if (m != n) {
            return false;
        }
        
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            
            if (map1.containsKey(c)) {
                if (!map1.get(c).equals(word)) {
                    return false;
                }
            }
            else {
                if (map2.containsKey(word)) {
                    return false;
                }
                map1.put(c, word);
                map2.put(word, c);
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(WordPattern.solution("abba", "dog cat cat dog"));
        System.out.println(WordPattern.solution("abba", "dog cat cat fish"));
        System.out.println(WordPattern.solution("aaaa", "dog cat cat dog"));
        System.out.println(WordPattern.solution("abba", "dog dog dog dog"));
    }

}
