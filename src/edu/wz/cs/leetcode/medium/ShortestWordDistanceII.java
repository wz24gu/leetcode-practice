package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 244. Shortest Word Distance II<br>
 * https://leetcode.com/problems/shortest-word-distance-ii<br><br>
 * 
 * This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your 
 * method will be called repeatedly many times with different parameters. How would you optimize it?<br>
 * 
 * Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 
 * and word2 and return the shortest distance between these two words in the list.<br>
 * 
 * For example:<br>
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].<br>
 * Given word1 = "coding", word2 = "practice", return 3.<br>
 * Given word1 = "makes", word2 = "coding", return 1.<br>
 * 
 * Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistanceII {
    
    private Map<String, List<Integer>> map;
    
    public ShortestWordDistanceII(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<Integer>());
            }
            map.get(words[i]).add(i);
        }        
    }
    
    // TODO: we can also use two pointers
    public int shortest(String word1, String word2) {
        int result = Integer.MAX_VALUE;
        for (int p1 : map.get(word1)) {
            for (int p2 : map.get(word2)) {
                result = Math.min(result, Math.abs(p1 - p2));
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        ShortestWordDistanceII distance = new ShortestWordDistanceII(words);
        System.out.println(distance.shortest("coding", "practice"));
        System.out.println(distance.shortest("makes", "coding"));
    }

}
