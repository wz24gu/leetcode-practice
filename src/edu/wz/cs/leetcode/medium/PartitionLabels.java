package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 763. Partition Labels<br>
 * https://leetcode.com/problems/partition-labels<br><br>
 * 
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that 
 * each letter appears in at most one part, and return a list of integers representing the size of these parts.<br><br>
 * 
 * Note:<br>
 * 1. S will have length in range [1, 500].<br>
 * 2. S will consist of lowercase letters ('a' to 'z') only.
 */
public class PartitionLabels {
    
    public static List<Integer> solution(String s) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        
        int n = s.length();
        int[] lastPosition = new int[26];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            lastPosition[c - 'a'] = i;
        }
        
        int start = 0;
        int last = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            last = Math.max(last, lastPosition[c - 'a']);
            if (i == last) {
                result.add(last - start + 1);
                start = last + 1;
            }
        }
        
        return result;
    }
    
    public static List<Integer> solutionSlidingWindow(String s) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        Map<Character, Integer> curr = new HashMap<>();
        int n = s.length();
        int left = 0;
        int right = 0;
        
        while (right < n) {
            char c = s.charAt(right);
            if (!curr.containsKey(c)) {
                curr.put(c, map.get(c));
            }
            
            curr.put(c, curr.get(c) - 1);
            if (curr.get(c) == 0) {
                curr.remove(c);
            }
            
            if (curr.isEmpty()) {
                result.add(right - left + 1);
                left = right + 1;
            }
            
            right++;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(PartitionLabels.solution("ababcbacadefegdehijhklij"));
        System.out.println(PartitionLabels.solutionSlidingWindow("ababcbacadefegdehijhklij"));
    }

}
