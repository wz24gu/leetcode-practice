package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. Word Break<br>
 * https://leetcode.com/problems/word-break<br><br>
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be 
 * segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not 
 * contain duplicate words.<br>
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].<br>
 * Return true because "leetcode" can be segmented as "leet code".<br>
 * 
 * UPDATE (2017/1/4): The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please 
 * reload the code definition to get the latest changes.
 */
public class WordBreak {
    
    public static boolean solution(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
        System.out.println(WordBreak.solution("leetcode", wordDict));
    }
    
}
