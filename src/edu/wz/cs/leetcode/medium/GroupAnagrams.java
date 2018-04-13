package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. Group Anagrams<br>
 * https://leetcode.com/problems/group-anagrams<br><br>
 * 
 * Given an array of strings, group anagrams together.<br>
 * 
 * Note: All inputs will be in lower-case.
 */
public class GroupAnagrams {
    
    public static List<List<String>> solution(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String t = generate(str);
            if (!map.containsKey(t)) {
                map.put(t, new ArrayList<String>());
            }
            map.get(t).add(str);
        }
        
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }
    
    private static String generate(String str) {
        int[] freq = new int[26];
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int f : freq) {
            sb.append(f);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(GroupAnagrams.solution(strs));
    }

}
