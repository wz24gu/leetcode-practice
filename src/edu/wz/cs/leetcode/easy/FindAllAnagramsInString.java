package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. Find All Anagrams in a String<br>
 * https://leetcode.com/problems/find-all-anagrams-in-a-string<br><br>
 * 
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.<br>
 * 
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than
 * 20,100. The order of output does not matter.
 */
public class FindAllAnagramsInString {
    
    public static List<Integer> solution(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if (m > n) {
            return result;
        }
        
        int[] freq = new int[26];
        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
        }
        
        int count = 0;
        int left = 0;
        int right = 0;
        while (right < n) {
            char c1 = s.charAt(right++);
            if (freq[c1 - 'a'] > 0) {  // the character is in p
                count++;
            }
            freq[c1 - 'a']--;
            
            if (count == m) {  // found one
                result.add(left);
            }
            
            if (right - left >= m) {  // move window
                char c2 = s.charAt(left++);
                if (freq[c2 - 'a'] >= 0) {  // if the character is not in the p, freq[c] will be negative
                    count--;
                }
                freq[c2 - 'a']++;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(FindAllAnagramsInString.solution("cbaebabacd", "abc"));
        System.out.println(FindAllAnagramsInString.solution("abab", "ab"));
    }

}
