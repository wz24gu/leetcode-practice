package edu.wz.cs.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 358. Rearrange String k Distance Apart<br>
 * https://leetcode.com/problems/rearrange-string-k-distance-apart<br><br>
 * 
 * Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance 
 * k from each other.<br>
 * 
 * All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty 
 * string "".
 */
public class RearrangeStringKDistanceApart {
    
    public static String solution(String s, int k) {
        if (k == 0) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        pq.addAll(map.entrySet());
        
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> current = pq.poll();
            sb.append(current.getKey());
            current.setValue(current.getValue() - 1);
            queue.offer(current);
            if (queue.size() < k) {
                continue;
            }
            
            Map.Entry<Character, Integer> front = queue.poll();
            if (front.getValue() > 0) {
                pq.offer(front);
            }
        }
        
        return sb.length() == s.length() ? sb.toString() : "";
    }
    
    public static void main(String[] args) {
        System.out.println(RearrangeStringKDistanceApart.solution("aabbcc", 3));
        System.out.println(RearrangeStringKDistanceApart.solution("aaabc", 3));
        System.out.println(RearrangeStringKDistanceApart.solution("aaadbbcc", 2));
    }

}
