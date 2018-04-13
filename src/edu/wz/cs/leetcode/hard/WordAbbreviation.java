package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 527. Word Abbreviation<br/>
 * 
 * Given an array of n distinct non-empty strings, you need to generate minimal possible abbreviations for every word 
 * following rules below.<br>
 * 
 * 1. Begin with the first character and then the number of characters abbreviated, which followed by the last character.<br/>
 * 2. If there are any conflict, that is more than one words share the same abbreviation, a longer prefix is used 
 * instead of only the first character until making the map from word to abbreviation become unique. In other words, a 
 * final abbreviation cannot map to more than one original words.<br/>
 * 3. If the abbreviation doesn't make the word shorter, then keep it as original.<br/><br/>
 * 
 * Note:<br/>
 * 1. Both n and the length of each word will not exceed 400.<br/>
 * 2. The length of each word is greater than 1.<br/>
 * 3. The words consist of lowercase English letters only.<br/>
 * 3. The return answers should be in the same order as the original array.
 */
public class WordAbbreviation {
    
    public static List<String> solution(String[] dict) {
        if (dict == null || dict.length == 0) {
            return new ArrayList<String>();
        }
        
        int len = dict.length;
        int[] pre = new int[len];
        String[] result = new String[len];
        for (int i = 0; i < len; i++) {
            pre[i] = 1;
            result[i] = abbreviate(dict[i], pre[i]);
        }
        
        for (int i = 0; i < len; i++) {
            while (true) {
                Set<Integer> set = new HashSet<>();  // create a new Set each time
                for (int j = i + 1; j < len; j++) {
                    if (result[i].equals(result[j])) {
                        set.add(j);
                    }
                }
                if (set.isEmpty()) {
                    break;  // does not find duplicate abbreviations in this round
                }
                
                set.add(i);
                for (int k : set) {
                    result[k] = abbreviate(dict[k], ++pre[k]);  // try the next character for the duplicated abbreviations
                }
            }
        }
        
        return Arrays.asList(result);
    }
    
    private static String abbreviate(String s, int k) {
        if (k >= s.length() - 2) {  // k at the last but one position, abbreviation does not shorten the word
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, k));  // 0 ... k-1
        sb.append(s.length() - k - 1);
        sb.append(s.charAt(s.length() - 1));  // last character
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String[] dict = {"like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"};
        System.out.println(WordAbbreviation.solution(dict));
    }

}
