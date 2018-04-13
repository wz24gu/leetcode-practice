package edu.wz.cs.leetcode.medium;

import java.util.Arrays;
import java.util.List;

/**
 * 524. Longest Word in Dictionary through Deleting<br>
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting<br><br>
 * 
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting 
 * some characters of the given string. If there are more than one possible results, return the longest word with the 
 * smallest lexicographical order. If there is no possible result, return the empty string.<br><br>
 * 
 * Note:<br>
 * 1. All the strings in the input will only contain lower-case letters.<br>
 * 2. The size of the dictionary won't exceed 1,000.<br>
 * 3. The length of all the strings in the input won't exceed 1,000.
 */
public class LongestWordInDictionaryThroughDeleting {
    
    public static String solution(String s, List<String> d) {        
        String result = "";
        
        for (String word : d) {
            int i = 0;
            int n = word.length();
            for (char c : s.toCharArray()) {
                if (i < n && c == word.charAt(i)) {
                    i++;
                }
                
                if (i == n && n >= result.length()) {
                    if (n > result.length() || word.compareTo(result) < 0) {
                        result = word;
                    }
                }
            }            
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        String[] strings = {"ale", "apple", "monkey", "plea"};
        System.out.println(LongestWordInDictionaryThroughDeleting.solution("abpcplea", Arrays.asList(strings)));
        
        String[] strings2 = {"a", "b", "c"};
        System.out.println(LongestWordInDictionaryThroughDeleting.solution("abpcplea", Arrays.asList(strings2)));
    }

}
