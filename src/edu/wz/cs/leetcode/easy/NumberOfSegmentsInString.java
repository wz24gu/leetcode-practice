package edu.wz.cs.leetcode.easy;

/**
 * 434. Number of Segments in a String<br>
 * https://leetcode.com/problems/number-of-segments-in-a-string<br><br>
 * 
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space
 * characters. Please note that the string does not contain any non-printable characters.<br>
 * 
 * Example:<br>
 * Input: "Hello, my name is John"<br>
 * Output: 5
 */
public class NumberOfSegmentsInString {
    
    public static int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            count++;
            while (i < n && s.charAt(i) != ' ') {
                i++;
            }
        }
        return count;
    }
    
    public static int solutionAlt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int n = s.length();
        int i = 0;
        int count = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            }
            else {
                int j = i;
                while (j < n && s.charAt(j) != ' ') {
                    j++;
                }
                count++;
                i = j;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(NumberOfSegmentsInString.solution(" Hello, my name is John "));
        System.out.println(NumberOfSegmentsInString.solutionAlt(" Hello, my name is John "));
    }

}
