package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 126. Word Ladder II<br>
 * https://leetcode.com/problems/word-ladder-ii<br><br>
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) 
 * from beginWord to endWord, such that:<br>
 * Only one letter can be changed at a time<br>
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.<br><br>
 * 
 * Note:<br>
 * 1. Return an empty list if there is no such transformation sequence.<br>
 * 2. All words have the same length.<br>
 * 3. All words contain only lowercase alphabetic characters.<br>
 * 4. You may assume no duplicates in the word list.<br>
 * 5. You may assume beginWord and endWord are non-empty and are not the same.<br>
 * 
 * UPDATE (2017/1/20):<br>
 * The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code 
 * definition to get the latest changes.
 */
public class WordLadderII {

    public static List<List<String>> solution(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        
        Queue<List<String>> paths = new LinkedList<>();
        List<String> path0 = new LinkedList<>();
        path0.add(beginWord);
        paths.offer(path0);
        
        int len = 1;
        int minLen = Integer.MAX_VALUE;
        Set<String> used = new HashSet<>();
        while (!paths.isEmpty()) {
            List<String> path = paths.poll();
            if (path.size() > len) {
                dict.removeAll(used);
                used.clear();
                len = path.size();
                if (len > minLen) {
                    break;
                }
            }
            
            String word = path.get(len - 1);
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char old = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (arr[i] == c) {
                        continue;
                    }
                    
                    arr[i] = c;
                    String newWord = new String(arr);
                    if (dict.contains(newWord)) {
                        used.add(newWord);
                        List<String> newPath = new LinkedList<>(path);
                        newPath.add(newWord);
                        if (newWord.equals(endWord)) {
                            res.add(newPath);
                            minLen = len + 1;
                        }
                        else {
                            paths.add(newPath);
                        }
                    }
                }
                arr[i] = old;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(WordLadderII.solution("hit", "cog", wordList));
    }

}
