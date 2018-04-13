package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. Substring with Concatenation of All Words<br>
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words<br><br>
 * 
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of 
 * substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.<br>
 * 
 * For example, given:<br>
 * s: "barfoothefoobarman"; words: ["foo", "bar"]<br>
 * You should return the indices: [0,9], (order does not matter).
 */
public class SubstringWithConcatenationOfAllWords {
    
    public static List<Integer> solution(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        
        Map<String, Integer> map1 = new HashMap<>();
        for (String word : words) {
            map1.put(word, map1.getOrDefault(word, 0) + 1);
        }
        
        int n = words.length;
        int m = words[0].length();
        int len = s.length();
        
        for (int i = 0; i < len - n * m; i++) {
            Map<String, Integer> map2 = new HashMap<>();
            int j;
            for (j = 0; j < n; j++) {
                String t = s.substring(i + j * m, i + j * m + m);
                if (!map1.containsKey(t)) {
                    break;
                }
                map2.put(t, map2.getOrDefault(t, 0) + 1);
                if (map2.get(t) > map1.get(t)) {
                    break;
                }
            }
            if (j == n) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    public static List<Integer> solutionX(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        
        Map<String, Integer> map1 = new HashMap<>();
        for (String word : words) {
            map1.put(word, map1.getOrDefault(word, 0) + 1);
        }
        
        int n = words.length;
        int m = words[0].length();
        int len = s.length();
        
        for (int i = 0; i < m; i++) {
            int left = i;
            int count = 0;
            Map<String, Integer> map2 = new HashMap<>();
            
            for (int j = i; j <= len - m; j += m) {
                String t = s.substring(j, j + m);
                if (map1.containsKey(t)) {
                    map2.put(t, map2.getOrDefault(t, 0) + 1);
                    if (map2.get(t) <= map1.get(t)) {
                        count++;
                    }
                    else {
                        while (map2.get(t) > map1.get(t)) {
                            String t1 = s.substring(left, left + m);
                            map2.put(t1, map2.get(t1) - 1);
                            if (map2.get(t1) < map1.get(t1)) {
                                count--;
                            }
                            left += m;
                        }
                    }
                    if (count == n) {
                        result.add(left);
                        String t1 = s.substring(left, left + m);
                        map2.put(t1, map2.get(t1) - 1);
                        count--;
                        left += m;
                    }
                }
                else {
                    map2.clear();
                    count = 0;
                    left = j + m;
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        String[] words = {"foo", "bar"};
        System.out.println(SubstringWithConcatenationOfAllWords.solution("barfoothefoobarman", words));
        System.out.println(SubstringWithConcatenationOfAllWords.solutionX("barfoothefoobarman", words));
    }

}
