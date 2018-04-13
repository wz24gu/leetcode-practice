package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 692. Top K Frequent Words<br>
 * https://leetcode.com/problems/top-k-frequent-words<br><br>
 * 
 * Given a non-empty list of words, return the k most frequent elements.<br>
 * 
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the 
 * word with the lower alphabetical order comes first.<br>
 * 
 * Note:<br>
 * 1. You may assume k is always valid, 1 <= k <= number of unique elements.<br>
 * 2. Input words contain only lowercase letters.<br>
 * 
 * Follow up: Try to solve it in O(n log k) time and O(n) extra space.
 */
public class TopKFrequentWords {
    
    @SuppressWarnings("unchecked")
    public static List<String> solution(String[] words, int k) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0 || k <= 0) {
            return result;
        }
        
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        int n = words.length;
        PriorityQueue<String>[] bucket = (PriorityQueue<String>[]) new PriorityQueue[n+1];
        for (String word : map.keySet()) {
            int freq = map.get(word);
            if (bucket[freq] == null) {
                bucket[freq] = new PriorityQueue<String>();
            }
            bucket[freq].add(word);
        }
        
        for (int i = n - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                while (k > 0 && !bucket[i].isEmpty()) {
                    result.add(bucket[i].poll());
                    k--;
                }
            }
            if (k <= 0) {
                break;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(TopKFrequentWords.solution(words, 2));
        
        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(TopKFrequentWords.solution(words2, 4));
    }

}
