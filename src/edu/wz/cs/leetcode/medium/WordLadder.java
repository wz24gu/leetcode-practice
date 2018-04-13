package edu.wz.cs.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 127. Word Ladder<br>
 * https://leetcode.com/problems/word-ladder<br><br>
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation 
 * sequence from beginWord to endWord, such that:<br>
 * 1. Only one letter can be changed at a time.<br>
 * 2. Each transformed word must exist in the word list. Note that beginWord is not a transformed word.<br>
 * 
 * Note:<br>
 * 1. Return 0 if there is no such transformation sequence.<br>
 * 2. All words have the same length.<br>
 * 3. All words contain only lowercase alphabetic characters.<br>
 * 4. You may assume no duplicates in the word list.<br>
 * 5. You may assume beginWord and endWord are non-empty and are not the same.<br>
 * 
 * UPDATE (2017/1/20):<br>
 * The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code 
 * definition to get the latest changes.
 */
public class WordLadder {
    
    public static int solution(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        
        Set<String> set = new HashSet<>(wordList);
        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.offer(beginWord);
        map.put(beginWord, 1);
        
        while (!queue.isEmpty()) {
            String word = queue.poll();
            
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char[] arr = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    if (arr[i] == c) {
                        continue;
                    }
                    arr[i] = c;
                    
                    String newWord = new String(arr);
                    if (set.contains(newWord) && newWord.equals(endWord)) {
                        return map.get(word) + 1;
                    }
                    if (set.contains(newWord) && !map.containsKey(newWord)) {                        
                        map.put(newWord, map.get(word) + 1);
                        queue.add(newWord);
                    }
                }
            }
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot" , "dog", "lot", "log", "cog");
        System.out.println(WordLadder.solution("hit", "cog", wordList));
    }

}
