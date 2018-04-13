package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 243. Shortest Word Distance<br>
 * https://leetcode.com/problems/shortest-word-distance<br><br>
 * 
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.<br>
 * 
 * For example, assume that words = ["practice", "makes", "perfect", "coding", "makes"].<br>
 * Given word1 = “coding”, word2 = “practice”, return 3.<br>
 * Given word1 = "makes", word2 = "coding", return 1.<br><br>
 * 
 * Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistance {
    
    public static int solution(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }
        
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        for (int i : list1) {
            for (int j : list2) {
                if (Math.abs(i - j) < min) {
                    min = Math.abs(i - j);
                }
            }
        }
        return min;        
    }
    
    public static int solutionX(String[] words, String word1, String word2) {
        int min = words.length;
        int p = -1;
        int q = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                p = i;
            }
            else if (words[i].equals(word2)) {
                q = i;
            }
            if (p != -1 && q != -1) {
                min = Math.min(min, Math.abs(p - q));
            }
        }
        return min;
    }
    
    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(ShortestWordDistance.solution(words, "coding", "practice"));
        System.out.println(ShortestWordDistance.solution(words, "coding", "makes"));
        
        System.out.println(ShortestWordDistance.solutionX(words, "coding", "practice"));
        System.out.println(ShortestWordDistance.solutionX(words, "coding", "makes"));
    }

}
