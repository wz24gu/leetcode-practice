package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 745. Prefix and Suffix Search<br>
 * https://leetcode.com/problems/prefix-and-suffix-search<br><br>
 * 
 * Given many words, words[i] has weight i.<br>
 * 
 * Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix). It will return the 
 * word with given prefix and suffix with maximum weight. If no word exists, return -1.<br><br>
 * 
 * Note:<br>
 * 1. words has length in range [1, 15000].<br>
 * 2. For each test case, up to words.length queries WordFilter.f may be made.<br>
 * 3. words[i] has length in range [1, 10].<br>
 * 4. prefix, suffix have lengths in range [0, 10].<br>
 * 5. words[i] and prefix, suffix queries consist of lowercase letters only.
 */
public class PrefixAndSuffixSearchII {
    
    Map<String, List<Integer>> pMap;
    Map<String, List<Integer>> sMap;
    
    public PrefixAndSuffixSearchII(String[] words) {
        pMap = new HashMap<>();
        sMap = new HashMap<>();
        int k = 0;
        for (String word : words) {
            int n = word.length();
            for (int i = 0; i < n; i++) {
                String p = word.substring(0, i);                
                if (!pMap.containsKey(p)) {
                    pMap.put(p, new ArrayList<Integer>());
                }
                pMap.get(p).add(k);
                
                String s = word.substring(n - i);
                if (!sMap.containsKey(s)) {
                    sMap.put(s, new ArrayList<Integer>());
                }
                sMap.get(s).add(k);
            }
            k++;
        }
    }
    
    public int f(String prefix, String suffix) {
        if (!pMap.containsKey(prefix) || !sMap.containsKey(suffix)) {
            return -1;
        }
        
        List<Integer> p = pMap.get(prefix);
        List<Integer> s = sMap.get(suffix);
        int i = p.size() - 1;
        int j = s.size() - 1;
        while (i >= 0 && j >= 0) {
            if (p.get(i) < s.get(j)) {
                j--;
            }
            else if (p.get(i) > s.get(j)) {
                i--;
            }
            else {
                return p.get(i);
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        String[] words = {"apple"};
        PrefixAndSuffixSearchII prefixAndSuffixSearch = new PrefixAndSuffixSearchII(words);
        System.out.println(prefixAndSuffixSearch.f("a", "e"));
        System.out.println(prefixAndSuffixSearch.f("b", ""));
    }

}
