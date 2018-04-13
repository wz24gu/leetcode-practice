package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 748. Shortest Completing Word<br>
 * https://leetcode.com/problems/shortest-completing-word<br><br>
 * 
 * Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. 
 * Such a word is said to complete the given string licensePlate.<br>
 * 
 * Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.<br>
 * 
 * It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.<br>
 * 
 * The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", 
 * the word "pair" does not complete the licensePlate, but the word "supper" does.<br><br>
 * 
 * Note:<br>
 * 1. licensePlate will be a string with length in range [1, 7].<br>
 * 2. licensePlate will contain digits, spaces, or letters (uppercase or lowercase).<br>
 * 3. words will have a length in the range [10, 1000].<br>
 * 4. Every words[i] will consist of lowercase letters, and have length in range [1, 15].
 */
public class ShortestCompletingWord {
    
    public static String solution(String licensePlate, String[] words) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String word : words) {
            int len = word.length();
            if (!map.containsKey(len)) {
                map.put(len, new ArrayList<String>());
            }
            map.get(len).add(word);
        }
        
        List<Character> chars = new ArrayList<>();
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                chars.add(c);
            }
        }
        
        int n = chars.size();
        for (int len : map.keySet()) {
            if (len < n) {
                continue;
            }
            
            for (String word : map.get(len)) {
                boolean valid = true;
                int[] freq = new int[26];
                for (char c : word.toCharArray()) {
                    freq[c - 'a']++;
                }
                for (char c : chars) {
                    freq[c - 'a']--;
                    if (freq[c - 'a'] < 0) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    return word;
                }
            }
        }
        
        return "";
    }
    
    public static void main(String[] args) {
        String[] words = {"step", "steps", "stripe", "stepple"};
        System.out.println(ShortestCompletingWord.solution("1s3 PSt", words));
        
        String[] words2 = {"looks", "pest", "stew", "show"};
        System.out.println(ShortestCompletingWord.solution("1s3 456", words2));
    }

}
