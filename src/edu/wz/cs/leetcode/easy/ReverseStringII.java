package edu.wz.cs.leetcode.easy;

/**
 * 541. Reverse String II<br>
 * https://leetcode.com/problems/reverse-string-ii<br><br>
 * 
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from
 * the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but
 * greater than or equal to k characters, then reverse the first k characters and left the others as original.<br><br>
 * 
 * Restrictions:<br>
 * 1. The String consists of lower English letters only.<br>
 * 2. Length of the given string and k will be in the range [1, 10000]
 */
public class ReverseStringII {

    public static String solution(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        if (k == 1) {
            return s;
        }
        
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i += k * 2) {
            int j = Math.min(i + k - 1, array.length - 1);
            reverse(array, i, j);
        }
        
        return new String(array);
    }
    
    private static void reverse(char[] array, int i, int j) {
        while (i < j) {
            char swap = array[i];
            array[i] = array[j];
            array[j] = swap;
            i++;
            j--;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(ReverseStringII.solution("abcdefg", 2));
    }

}
