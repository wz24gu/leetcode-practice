package edu.wz.cs.leetcode.easy;

/**
 * 696. Count Binary Substrings<br>
 * https://leetcode.com/problems/count-binary-substrings<br><br>
 * 
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and
 * all the 0's and all the 1's in these substrings are grouped consecutively. Substrings that occur multiple times are
 * counted the number of times they occur.<br><br>
 * 
 * Note:<br>
 * 1. s.length will be between 1 and 50,000.<br>
 * 2. s will only consist of "0" or "1" characters.
 */
public class CountBinarySubstrings {
    
    public static int solution(String s) {
        int result = 0;
        
        int prev = 0;
        int curr = 1;  // start from the first character
        int n = s.length();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            }
            else {
                prev = curr;
                curr = 1;
            }
            
            if (prev >= curr) {
                result++;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(CountBinarySubstrings.solution("00110011"));
        System.out.println(CountBinarySubstrings.solution("10101"));
    }

}
