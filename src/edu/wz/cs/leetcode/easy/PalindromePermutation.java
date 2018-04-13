package edu.wz.cs.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 266. Palindrome Permutation<br>
 * 
 * Given a string, determine if a permutation of the string could form a palindrome.
 * For example, "code" -> False, "aab" -> True, "carerac" -> True.<br>
 * 
 * Hint:<br>
 * 1. Consider the palindromes of odd vs even length. What difference do you notice?<br>
 * 2. Count the frequency of each character.<br>
 * 3. If each character occurs even number of times, then it must be a palindrome.
 * How about character which occurs odd number of times?
 */
public class PalindromePermutation {
    
    // only applies to ASCII extended, not Unicode
    public static boolean solution(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        
        int[] index = new int[256];  // extended ASCII
        int n = s.length();
        for (int i = 0; i < n; i++) {
            index[s.charAt(i)] ^= 1;  // flip
        }
        
        int count = 0;
        for (int i = 0; i < 256; i++) {
            count += index[i];
        }
        return count <= 1;        
    }
    
    public static boolean solutionAlt(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int count = 0;
        for (int i : map.values()) {
            if (i % 2 != 0) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count <= 1;
    }
    
    public static void main(String[] args) {
        System.out.println(PalindromePermutation.solution("code"));
        System.out.println(PalindromePermutation.solution("aab"));
        System.out.println(PalindromePermutation.solution("carerac"));
        
        System.out.println(PalindromePermutation.solutionAlt("code"));
        System.out.println(PalindromePermutation.solutionAlt("aab"));
        System.out.println(PalindromePermutation.solutionAlt("carerac"));
    }

}
