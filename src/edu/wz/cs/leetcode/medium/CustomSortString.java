package edu.wz.cs.leetcode.medium;

/**
 * 791. Custom Sort String<br>
 * https://leetcode.com/problems/custom-sort-string<br><br>
 * 
 * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.<br>
 * 
 * S was sorted in some custom order previously. We want to permute the characters of T so that they match the order 
 * that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.<br>
 * 
 * Return any permutation of T (as a string) that satisfies this property.<br><br>
 * 
 * Note:<br>
 * 1. S has length at most 26, and no character is repeated in S.<br>
 * 2. T has length at most 200.<br>
 * 3. S and T consist of lowercase letters only.
 */
public class CustomSortString {
    
    public static String solution(String S, String T) {
        int[] count = new int[26];
        for (char c : T.toCharArray()) {
            count[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        for (char c = 'a'; c <= 'z'; c++) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(CustomSortString.solution("cba", "abcd"));
    }

}
