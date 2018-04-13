package edu.wz.cs.leetcode.hard;

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
public class PrefixAndSuffixSearchIII {    
    private String[] words;
    
    public PrefixAndSuffixSearchIII(String[] words) {
        this.words = words;
    }
    
    public int f(String prefix, String suffix) {
        int n = words.length;
        for (int i = n - 1; i >= 0; i--) {
            if (words[i].startsWith(prefix) && words[i].endsWith(suffix)) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        String[] words = {"apple"};
        PrefixAndSuffixSearchIII prefixAndSuffixSearch = new PrefixAndSuffixSearchIII(words);
        System.out.println(prefixAndSuffixSearch.f("a", "e"));
        System.out.println(prefixAndSuffixSearch.f("b", ""));
    }

}
