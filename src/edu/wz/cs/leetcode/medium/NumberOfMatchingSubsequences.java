package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 792. Number of Matching Subsequences<br>
 * https://leetcode.com/problems/number-of-matching-subsequences<br><br>
 * 
 * Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.<br><br>
 * 
 * Note:<br>
 * 1. All words in words and S will only consists of lowercase letters.<br>
 * 2. The length of S will be in the range of [1, 50000].<br>
 * 3. The length of words will be in the range of [1, 5000].<br>
 * 4. The length of words[i] will be in the range of [1, 50].
 */
public class NumberOfMatchingSubsequences {
    
    public static int solution(String S, String[] words) {
        Map<Character, Queue<String>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, new LinkedList<String>());
        }
        
        for (String word : words) {
            map.get(word.charAt(0)).add(word);
        }
        
        int count = 0;
        for (char c : S.toCharArray()) {
            Queue<String> queue = map.get(c);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.length() == 1) {
                    count++;
                }
                else {
                    map.get(word.charAt(1)).add(word.substring(1));
                }
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(NumberOfMatchingSubsequences.solution("abcde", words));
    }

}
