package edu.wz.cs.leetcode.easy;

/**
 * 58. Length of Last Word<br>
 * https://leetcode.com/problems/length-of-last-word<br><br>
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last 
 * word in the string.<br>
 * 
 * If the last word does not exist, return 0.<br>
 * 
 * Note: A word is defined as a character sequence consists of non-space characters only.
 */
public class LengthOfLastWord {

    public static int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        // trim trailing space
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        
        int count = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }
        return count;
    }
    
    public static int solutionAlt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                i--;
            }
            else {
                int j = i;
                while (j >= 0 && s.charAt(j) != ' ') {
                    j--;
                }
                return i - j;
            }
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        System.out.println(LengthOfLastWord.solution("Hello World"));
        System.out.println(LengthOfLastWord.solutionAlt("Hello World"));
    }
    
}
