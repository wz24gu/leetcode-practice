package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. Permutation in String<br>
 * https://leetcode.com/problems/permutation-in-string<br><br>
 * 
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, 
 * one of the first string's permutations is the substring of the second string.<br><br>
 * 
 * Note:<br>
 * 1. The input strings only contain lower case letters.<br>
 * 2. The length of both given strings is in range [1, 10,000].
 */
public class PermutationInString {
    
    public static boolean solution(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        
        int[] count = new int[26];  // use int[] as a map
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (zero(count)) {
            return true;
        }
        
        // sliding window
        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;  // new character move in
            count[s2.charAt(i - len1) - 'a']++;  // old character move out
            if (zero(count)) {
                return true;
            }
        }
        
        return false;
    }
    
    private static boolean zero(int[] count) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean solutionAlt(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m > n) {
            return false;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < n) {
            char c1 = s2.charAt(right++);
            if (map.containsKey(c1)) {
                if (map.get(c1) > 0) {
                    count++;
                }
                map.put(c1, map.get(c1) - 1);
            }
            
            if (right - left == m) {
                if (count == m) {
                    return true;
                }
                char c2 = s2.charAt(left++);
                if (map.containsKey(c2)) {
                    if (map.get(c2) >= 0) {
                        count--;
                    }
                    map.put(c2, map.get(c2) + 1);
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(PermutationInString.solution("ab", "eidbaooo"));
        System.out.println(PermutationInString.solution("ab", "eidboaoo"));
        System.out.println(PermutationInString.solutionAlt("ab", "eidbaooo"));
        System.out.println(PermutationInString.solutionAlt("ab", "eidboaoo"));
    }

}
