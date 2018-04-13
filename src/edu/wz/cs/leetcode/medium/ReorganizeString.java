package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 767. Reorganize String<br>
 * https://leetcode.com/problems/reorganize-string<br><br>
 * 
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are 
 * not the same.<br>
 * 
 * If possible, output any possible result.  If not possible, return the empty string.<br>
 * 
 * Note: S will consist of lowercase letters and have length in range [1, 500].
 */
public class ReorganizeString {
    
    public static String solution(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        int n = S.length();
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            if (count > (n + 1) / 2) {
                return "";
            }
            map.put(c, count);
        }
        
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char c : map.keySet()) {
            pq.offer(new int[] {c, map.get(c)});
        }
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] c1 = pq.poll();
            if (sb.length() == 0 || c1[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char) c1[0]);
                if (--c1[1] > 0) {
                    pq.offer(c1);
                }
            }
            else {
                int[] c2 = pq.poll();
                sb.append((char) c2[0]);
                if (--c2[1] > 0) {
                    pq.offer(c2);
                }
                pq.offer(c1);
            }
        }
        
        return sb.toString();   
    }
    
    public static void main(String[] args) {
        System.out.println(ReorganizeString.solution("aab"));
        System.out.println(ReorganizeString.solution("aaab"));
    }

}
