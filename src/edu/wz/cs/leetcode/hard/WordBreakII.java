package edu.wz.cs.leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 140. Word Break II<br>
 * https://leetcode.com/problems/word-break-ii<br><br>
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct 
 * a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.<br>
 * 
 * Return all such possible sentences.<br>
 * 
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"].<br>
 * A solution is ["cats and dog", "cat sand dog"].<br>
 * 
 * UPDATE (2017/1/4):<br>
 * The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code 
 * definition to get the latest changes.
 */
public class WordBreakII {
    
    public static List<String> solution(String s, List<String> wordDict) {
        Map<String, List<String>> map = new HashMap<>();
        return dfs(s, wordDict, map);
    }
    
    private static List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        
        List<String> result = new LinkedList<>();
        if (s.length() == 0) {
            result.add("");
            return result;
        }
        
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> subs = dfs(s.substring(word.length()), wordDict, map);
                for (String sub : subs) {
                    result.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        map.put(s, result);
        System.out.println(map);
        return result;
    }
    
    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(WordBreakII.solution("catsanddog", wordDict));
    }

}
