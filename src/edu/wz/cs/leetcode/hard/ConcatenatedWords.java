package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 472. Concatenated Words<br/>
 * https://leetcode.com/problems/concatenated-words<br/><br/>
 * 
 * Given a list of words (without duplicates), please write a program that returns all concatenated words in the given 
 * list of words.<br/>
 * 
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given 
 * array.<br/><br/>
 * 
 * Note:<br/>
 * 1. The number of elements of the given array will not exceed 10,000<br/>
 * 2. The length sum of elements in the given array will not exceed 600,000.<br/>
 * 3. All the input string will only include lower case letters.<br/>
 * 4. The returned elements order does not matter.
 */
public class ConcatenatedWords {
    
    public static List<String> solution(String[] words) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 2) {
            return result;
        }
        
        Set<String> dict = new HashSet<>(Arrays.asList(words));
        
        for (String word : words) {
            dict.remove(word);
            int len = word.length();
            if (len == 0) {
                continue;
            }
            
            boolean[] b = new boolean[len + 1];
            b[0] = true;
            for (int i = 0; i < len + 1; i++) {
                for (int j = 0; j < i; j++) {
                    if (b[j] && dict.contains(word.substring(j, i))) {
                        b[i] = true;
                        break;
                    }
                }
            }
            
            if (b[len]) {
                result.add(word);
            }
            dict.add(word);    
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        String[] words = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        System.out.println(ConcatenatedWords.solution(words));
    }

}
