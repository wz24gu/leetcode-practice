package edu.wz.cs.leetcode.easy;

/**
 * 680. Valid Palindrome II<br>
 * https://leetcode.com/problems/valid-palindrome-ii<br><br>
 * 
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.<br>
 * 
 * Note: The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class ValidPalindromeII {
    
    public static boolean solution(String s) {
        if (s == null || s.length() <= 2) {
            return true;
        }
        
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return valid(s, left + 1, right) || valid(s, left, right - 1);  // tricky, cannot use count
            }
            left++;
            right--;
        }
        return true;
    }
    
    private static boolean valid(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(ValidPalindromeII.solution("aba"));
        System.out.println(ValidPalindromeII.solution("abca"));
    }

}
