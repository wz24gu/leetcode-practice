package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 761. Special Binary String<br>
 * https://leetcode.com/problems/special-binary-string<br><br>
 * 
 * Special binary strings are binary strings with the following two properties:<br>
 * 
 * The number of 0's is equal to the number of 1's.<br>
 * Every prefix of the binary string has at least as many 1's as 0's.<br>
 * Given a special string S, a move consists of choosing two consecutive, non-empty, special substrings of S, and 
 * swapping them. (Two strings are consecutive if the last character of the first string is exactly one index before the 
 * first character of the second string.)<br>
 * 
 * At the end of any number of moves, what is the lexicographically largest resulting string possible?<br><br>
 * 
 * Note:<br>
 * 1. S has length at most 50.<br>
 * 2. S is guaranteed to be a special binary string as defined above.
 */
public class SpecialBinaryString {
    
    public static String solution(String S) {
        List<String> res = new ArrayList<>();
        int count = 0;
        int n = S.length();
        int i = 0;
        
        for (int j = 0; j < n; j++) {
            if (S.charAt(j) == '1') {
                count++;
            }
            else {
                count--;
            }
            
            if (count == 0) {
                res.add('1' + solution(S.substring(i + 1, j)) + '0');
                i = j + 1;
            }            
        }
        
        Collections.sort(res, Collections.reverseOrder());
        return String.join("", res);
    }
    
    public static void main(String[] args) {
        System.out.println(SpecialBinaryString.solution("11011000"));
    }

}
