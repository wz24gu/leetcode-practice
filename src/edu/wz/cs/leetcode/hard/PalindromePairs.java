package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 336. Palindrome Pairs<br>
 * https://leetcode.com/problems/palindrome-pairs<br><br>
 * 
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation 
 * of the two words, i.e. words[i] + words[j] is a palindrome.
 */
public class PalindromePairs {
    
    public static List<List<Integer>> solution(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length <= 1) {
            return result;
        }
        
        Map<String, Integer> map = new HashMap<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            map.put(words[i], i);
        }
        
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int m = word.length();
            
            for (int j = 0; j <= m; j++) {  // = to handle empty string ""
                String s1 = word.substring(0, j);
                String s2 = word.substring(j);
                
                if (palindrome(s1)) {
                    String s2r = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(s2r) && map.get(s2r) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(s2r));
                        list.add(i);
                        result.add(list);
                    }
                }
                
                if (palindrome(s2)) {
                    String s1r = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(s1r) && map.get(s1r) != i && s2.length() != 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(s1r));
                        result.add(list);
                    }
                }
            }
        }
        
        return result;
    }
    
    private static boolean palindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        String[] words = {"bat", "tab", "cat"};
        System.out.println(PalindromePairs.solution(words));
        
        String[] words2 = {"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(PalindromePairs.solution(words2));
    }

}
