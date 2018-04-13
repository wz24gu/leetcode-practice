package edu.wz.cs.leetcode.easy;

/**
 * 796. Rotate String<br>
 * https://leetcode.com/problems/rotate-string<br><br>
 * 
 * We are given two strings, A and B.<br>
 * 
 * A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, 
 * if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some 
 * number of shifts on A.<br>
 * 
 * Note: A and B will have length at most 100.
 */
public class RotateString {
    
    public static boolean solution(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }

}
