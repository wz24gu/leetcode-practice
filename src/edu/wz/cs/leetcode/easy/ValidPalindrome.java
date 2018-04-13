package edu.wz.cs.leetcode.easy;

/**
 * 125. Valid Palindrome<br>
 * https://leetcode.com/problems/valid-palindrome<br><br>
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.<br>
 * For example,<br>
 * "A man, a plan, a canal: Panama" is a palindrome.<br>
 * "race a car" is not a palindrome.<br>
 * 
 * Note: Have you consider that the string might be empty? This is a good question to ask during an interview. For the 
 * purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    
    public static boolean solution(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    public static boolean solutionAlt(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!valid(s.charAt(i))) {
                i++;
            }
            else if (!valid(s.charAt(j))) {
                j--;
            }
            else {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
    
    private static boolean valid(char c) {
        return c >= '0' && c <= '9'
            || c >= 'a' && c <= 'z';
    }
    
    public static void main(String[] args) {
        System.out.println(ValidPalindrome.solution("A man, a plan, a canal: Panama"));
        System.out.println(ValidPalindrome.solution("race a car"));
        
        System.out.println(ValidPalindrome.solutionAlt("A man, a plan, a canal: Panama"));
        System.out.println(ValidPalindrome.solutionAlt("race a car"));
    }

}
