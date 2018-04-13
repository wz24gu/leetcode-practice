package edu.wz.cs.leetcode.hard;

/**
 * 10. Regular Expression Matching<br>
 * https://leetcode.com/problems/regular-expression-matching<br><br>
 * 
 * Implement regular expression matching with support for '.' and '*'.
 */
public class RegularExpressionMatching {
    
    public static boolean solution(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.length() == 1) {
            return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        }
        
        if (p.charAt(1) != '*') {
            if (s.length() == 0) {
                return false;
            }
            else {
                return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                    && solution(s.substring(1), p.substring(1));
            }
        }
        else {
            while (s.length() != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                if (solution(s, p.substring(2))) {
                    return true;
                }
                s = s.substring(1);
            }
            return solution(s, p.substring(2));
        }
    }
    
    public static void main(String[] args) {
        System.out.println(RegularExpressionMatching.solution("aa", "a"));
        System.out.println(RegularExpressionMatching.solution("aa", "aa"));
        System.out.println(RegularExpressionMatching.solution("aaa", "aa"));
        System.out.println(RegularExpressionMatching.solution("aa", "a*"));
        System.out.println(RegularExpressionMatching.solution("aa", ".*"));
        System.out.println(RegularExpressionMatching.solution("ab", ".*"));
        System.out.println(RegularExpressionMatching.solution("aab", "c*a*b"));
    }

}
