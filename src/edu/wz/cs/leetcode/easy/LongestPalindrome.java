package edu.wz.cs.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. Longest Palindrome<br>
 * https://leetcode.com/problems/longest-palindrome<br><br>
 * 
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can
 * be built with those letters. This is case sensitive, for example "Aa" is not considered a palindrome here.<br>
 * 
 * Note: Assume the length of given string will not exceed 1,010.
 */
public class LongestPalindrome {
    
    public static int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }        
        
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }        
        
        int count = 0;
        for (int i : map.values()) {
            if (i >= 2) {
                count += (i / 2) * 2;  // tricky code, not i % 2 == 0
            }
        }
        return count == n ? count : count + 1;
    }
    
    public static void main(String[] args) {
        System.out.println(LongestPalindrome.solution("dccaccd"));
        System.out.println(LongestPalindrome.solution("ccc"));
    }

}
