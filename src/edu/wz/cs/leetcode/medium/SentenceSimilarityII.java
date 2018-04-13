package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 737. Sentence Similarity II<br>
 * https://leetcode.com/problems/sentence-similarity-ii<br><br>
 * 
 * Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, 
 * determine if two sentences are similar.<br>
 * 
 * For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, if the 
 * similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].<br>
 * 
 * Note that the similarity relation is transitive. For example, if "great" and "good" are similar, and "fine" and "good" 
 * are similar, then "great" and "fine" are similar.<br>
 * 
 * Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being 
 * similar.<br>
 * 
 * Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs 
 * = [] are similar, even though there are no specified similar word pairs.<br>
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
public class SentenceSimilarityII {
    
    public static boolean solutionUF(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        
        Map<String, String> map = new HashMap<>();
        for (String[] p : pairs) {
            String parent1 = find(map, p[0]);
            String parent2 = find(map, p[1]);
            if (!parent1.equals(parent2)) {
                map.put(parent1, parent2);
            }   
        }
        
        for (int i = 0; i < words1.length; i++) {
            if (!words1[i].equals(words2[i]) && !find(map, words1[i]).equals(find(map, words2[i]))) {
                return false;
            }
        }
        return true;
    }
    
    private static String find(Map<String, String> map, String s) {
        if (!map.containsKey(s)) {
            map.put(s, s);
        }
        return s.equals(map.get(s)) ? s : find(map, map.get(s));
    }
    
    public static boolean solutionDFS(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        
        Map<String, Set<String>> map = new HashMap<>();
        for (String[] pair : pairs) {
            if (!map.containsKey(pair[0])) {
                map.put(pair[0], new HashSet<>());
            }
            if (!map.containsKey(pair[1])) {
                map.put(pair[1], new HashSet<>());
            }
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }
        
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) {
                continue;
            }
            if (!map.containsKey(words1[i])) {
                return false;
            }
            if (!dfs(words1[i], words2[i], map, new HashSet<>())) {
                return false;
            }            
        }
        
        return true;
    }
    
    private static boolean dfs(String source, String target, Map<String, Set<String>> map, Set<String> visited) {
        if (map.get(source).contains(target)) {
            return true;
        }
        
        visited.add(source);
        for (String next : map.get(source)) {
            if (!visited.contains(next) && dfs(next, target, map, visited)) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        String[] words1 = {"great", "acting", "skills"};
        String[] words2 = {"fine", "drama", "talent"};
        String[][] pairs = { {"great", "good"}, {"fine", "good"}, {"acting", "drama"}, {"skills", "talent"} };
        System.out.println(SentenceSimilarityII.solutionUF(words1, words2, pairs));
        System.out.println(SentenceSimilarityII.solutionDFS(words1, words2, pairs));
    }

}
