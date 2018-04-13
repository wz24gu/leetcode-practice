package edu.wz.cs.leetcode.easy;

/**
 * 459. Repeated Substring Pattern<br>
 * https://leetcode.com/problems/repeated-substring-pattern<br><br>
 * 
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of 
 * the substring together. You may assume the given string consists of lowercase English letter only and its length 
 * will not exceed 10000.
 */
public class RepeatedSubstringPattern {

    public static boolean solution(String s) {
        int n = s.length();
        
        for (int len = 1; len <= n / 2; len++) {
            if (n % len == 0) {
                String sub = s.substring(0, len);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n / len; i++) {
                    sb.append(sub);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(RepeatedSubstringPattern.solution("abab"));
        System.out.println(RepeatedSubstringPattern.solution("aba"));
        System.out.println(RepeatedSubstringPattern.solution("abcabcabcabc"));   
    }

}
