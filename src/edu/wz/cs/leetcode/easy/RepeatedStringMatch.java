package edu.wz.cs.leetcode.easy;

/**
 * 686. Repeated String Match<br>
 * https://leetcode.com/problems/repeated-string-match<br><br>
 * 
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. 
 * If no such solution, return -1.<br>
 * 
 * For example, with A = "abcd" and B = "cdabcdab".<br>
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A 
 * repeated two times ("abcdabcd").<br>
 * 
 * Note: The length of A and B will be between 1 and 10000.
 */
public class RepeatedStringMatch {
    
    public static int solution(String A, String B) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(A);
        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }
        
        if (sb.toString().contains(B)) {
            return count;
        }
        if (sb.append(A).toString().contains(B)) {
            return count + 1;
        }
        else {
            return -1;
        }        
    }
    
    public static void main(String[] args) {
        System.out.println(RepeatedStringMatch.solution("abcd", "abcdabcdabcd"));
    }

}
