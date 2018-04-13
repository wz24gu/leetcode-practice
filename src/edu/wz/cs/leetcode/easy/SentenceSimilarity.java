package edu.wz.cs.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 734. Sentence Similarity<br>
 * https://leetcode.com/problems/sentence-similarity<br><br>
 * 
 * Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, 
 * determine if two sentences are similar.<br>
 * 
 * For example, "great acting skills" and "fine drama talent" are similar, if the similar word pairs are pairs = 
 * [["great", "fine"], ["acting","drama"], ["skills","talent"]].<br>
 * 
 * Note that the similarity relation is not transitive. For example, if "great" and "fine" are similar, and "fine" and 
 * "good" are similar, "great" and "good" are not necessarily similar.<br>
 * 
 * However, similarity is symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" 
 * being similar.<br>
 * 
 * Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = 
 * [] are similar, even though there are no specified similar word pairs.<br>
 * 
 * Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] 
 * can never be similar to words2 = ["doubleplus","good"].<br><br>
 * 
 * Note:<br>
 * 1. The length of words1 and words2 will not exceed 1000.<br>
 * 2. The length of pairs will not exceed 2000.<br>
 * 3. The length of each pairs[i] will be 2.<br>
 * 4. The length of each words[i] and pairs[i][j] will be in the range [1, 20].
 */
public class SentenceSimilarity {
    
    public static boolean solution(String[] words1, String[] words2, String[][] pairs) {
        int m = words1.length;
        int n = words2.length;
        if (m != n) {
            return false;
        }
        
        Map<String, Set<String>> map = new HashMap<>();
        for (String[] pair : pairs) {
            if (!map.containsKey(pair[0])) {
                map.put(pair[0], new HashSet<String>());
            }
            map.get(pair[0]).add(pair[1]);
            
            if (!map.containsKey(pair[1])) {
                map.put(pair[1], new HashSet<String>());
            }
            map.get(pair[1]).add(pair[0]);
        }
        
        for (int i = 0; i < n; i++) {
            String word1 = words1[i];
            String word2 = words2[i];
            if (word1.equals(word2)) {
                continue;
            }
            if (!map.containsKey(word1) || !map.get(word1).contains(word2)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String[] words1 = {"great", "acting", "skills"};
        String[] words2 = {"fine", "drama", "talent"};
        String[][] pairs = { {"great", "fine"}, {"acting", "drama"}, {"skills", "talent"} };
        System.out.println(SentenceSimilarity.solution(words1, words2, pairs));
    }

}
