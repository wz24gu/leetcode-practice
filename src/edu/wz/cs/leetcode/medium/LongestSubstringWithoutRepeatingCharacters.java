package edu.wz.cs.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters<br>
 * https://leetcode.com/problems/longest-substring-without-repeating-characters<br><br>
 * 
 * Given a string, find the length of the longest substring without repeating characters.<br>
 * 
 * Examples:<br>
 * Given "abcabcbb", the answer is "abc", which the length is 3.<br>
 * Given "bbbbb", the answer is "b", with the length of 1.<br>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a 
 * subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    
    public static int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int left = 0;
        int right = 0;
        int max = 0;
        
        while (right < n) {
            while(right < n && set.add(s.charAt(right))) {
                right++;
            }
            
            max = Math.max(max, right - left);
            set.remove(s.charAt(left++));
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(LongestSubstringWithoutRepeatingCharacters.solution("abcabcbb"));
        System.out.println(LongestSubstringWithoutRepeatingCharacters.solution("bbbbb"));
        System.out.println(LongestSubstringWithoutRepeatingCharacters.solution("pwwkew"));
    }

}
