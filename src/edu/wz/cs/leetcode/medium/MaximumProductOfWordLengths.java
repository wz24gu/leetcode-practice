package edu.wz.cs.leetcode.medium;

/**
 * 318. Maximum Product of Word Lengths<br>
 * https://leetcode.com/problems/maximum-product-of-word-lengths<br><br>
 * 
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not 
 * share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, 
 * return 0.
 */
public class MaximumProductOfWordLengths {
    
    public static int solution(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        
        int result = 0;
        int n = words.length;
        int[] mask = new int[n];
        for (int i = 0; i < n; i++) {            
            for (char c : words[i].toCharArray()) {
                mask[i] |= (1 << (c - 'a'));  // left shift 1 with c - a positions
            }
            
            for (int j = i; j >= 0; j--) {
                if ((mask[i] & mask[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }            
        }
        
        return result;   
    }
    
    public static void main(String[] args) {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(MaximumProductOfWordLengths.solution(words));
        
        String[] words2 = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        System.out.println(MaximumProductOfWordLengths.solution(words2));
        
        String[] words3 = {"a", "aa", "aaa", "aaaa"};
        System.out.println(MaximumProductOfWordLengths.solution(words3));
    }

}
