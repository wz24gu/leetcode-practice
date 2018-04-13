package edu.wz.cs.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 269. Alien Dictionary<br>
 * https://leetcode.com/problems/alien-dictionary<br><br>
 * 
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You 
 * receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this 
 * new language. Derive the order of letters in this language.<br><br>
 * 
 * Note:<br>
 * 1. You may assume all letters are in lowercase.<br>
 * 2. You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.<br>
 * 3. If the order is invalid, return an empty string.<br>
 * 4. There may be multiple valid order of letters, return any one of them is fine.
 */
public class AlienDictionary {
    
    public static String solution(String[] words) {
        String result = "";
        if (words == null || words.length == 0) {
            return result;
        }        
        
        Map<Character, Integer> degree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                degree.put(c, 0);
            }
        }
        
        Map<Character, Set<Character>> map = new HashMap<>();
        int n = words.length;
        for (int i = 0; i < n - 1; i++) {
            String curr = words[i];
            String next = words[i+1];
            
            int len = Math.min(curr.length(), next.length());
            for (int j = 0; j < len; j++) {
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    if (!map.containsKey(c1)) {
                        map.put(c1, new HashSet<Character>());
                    }
                    if (!map.get(c1).contains(c2)) {
                        map.get(c1).add(c2);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        
        Queue<Character> queue = new LinkedList<>();
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) {
                queue.offer(c);
            }
        }
        
        while (!queue.isEmpty()) {
            char c = queue.poll();
            result += c;
            if (map.containsKey(c)) {
                for (char next : map.get(c)) {
                    degree.put(next, degree.get(next) - 1);
                    if (degree.get(next) == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        
        if (result.length() != degree.size()) {
            return "";
        }
        return result;
    }
    
    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(AlienDictionary.solution(words));
        
        String[] words2 = {"z", "x"};
        System.out.println(AlienDictionary.solution(words2));
        
        String[] words3 = {"z", "x", "z"};
        System.out.println(AlienDictionary.solution(words3));
    }
    

}
