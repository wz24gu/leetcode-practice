package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 451. Sort Characters By Frequency<br>
 * https://leetcode.com/problems/sort-characters-by-frequency<br><br>
 * 
 * Given a string, sort it in decreasing order based on the frequency of characters.
 */
public class SortCharactersByFrequency {
    
    @SuppressWarnings("unchecked")
    public static String solution(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int n = s.length();
        List<Character>[] buckets = (List<Character>[]) new List[n+1];
        for (char c : map.keySet()) {
            int i = map.get(c);
            if (buckets[i] == null) {
                buckets[i] = new ArrayList<Character>();
            }
            buckets[i].add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            if (buckets[i] == null) {
                continue;
            }
            for (int j = 0; j < buckets[i].size(); j++) {
                for (int k = 0; k < i; k++) {
                    sb.append(buckets[i].get(j));
                }
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(SortCharactersByFrequency.solution("tree"));
        System.out.println(SortCharactersByFrequency.solution("cccaaa"));
        System.out.println(SortCharactersByFrequency.solution("aAbb"));
    }

}
