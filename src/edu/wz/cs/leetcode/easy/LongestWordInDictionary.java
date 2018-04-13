package edu.wz.cs.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 720. Longest Word in Dictionary<br>
 * https://leetcode.com/problems/longest-word-in-dictionary<br><br>
 * 
 * Given a list of strings words representing an English Dictionary, find the longest word in words that can be built 
 * one character at a time by other words in words. If there is more than one possible answer, return the longest word 
 * with the smallest lexicographical order.<br>
 * 
 * If there is no answer, return the empty string.<br><br>
 * 
 * Note<br>
 * 1. All the strings in the input will only contain lowercase letters.<br>
 * 2. The length of words will be in the range [1, 1000].<br>
 * 3. The length of words[i] will be in the range [1, 30].
 */
public class LongestWordInDictionary {
    
    public static String solution(String[] words) {
        Arrays.sort(words);
        
        Set<String> set = new HashSet<>();
        set.add("");
        String result = words[0];
        
        for (String word : words) {
            if (set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                if (word.length() > result.length()) {
                    result = word;
                }
            }            
        }
        
        return result;
    }
    
    public static String solutionAlt(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        
        String result = "";
        outer:
        for (String word : words) {
            int n = word.length();
            for (int i = 1; i < n; i++) {
                if (!set.contains(word.substring(0, i))) {
                    continue outer;
                }
            }
            
            if (n > result.length() || n == result.length() && word.compareTo(result) < 0) {
                result = word;
            }            
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        String[] words = {"w", "wo", "wor", "worl", "world"};
        System.out.println(LongestWordInDictionary.solution(words));
        System.out.println(LongestWordInDictionary.solutionAlt(words));
        
        String[] words2 = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(LongestWordInDictionary.solution(words2));
        System.out.println(LongestWordInDictionary.solutionAlt(words2));
    }

}
