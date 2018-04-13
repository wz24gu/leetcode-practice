package edu.wz.cs.leetcode.easy;

import java.util.Arrays;

/**
 * 443. String Compression<br>
 * https://leetcode.com/problems/string-compression<br><br>
 * 
 * Given an array of characters, compress it in-place.<br> 
 * The length after compression must always be smaller than or equal to the original array.<br>
 * Every element of the array should be a character (not int) of length 1.<br>
 * After you are done modifying the input array in-place, return the new length of the array.<br>
 * 
 * Follow up: Could you solve it using only O(1) extra space?<br><br>
 * 
 * Note:<br>
 * 1. All characters have an ASCII value in [35, 126].<br>
 * 2. 1 <= len(chars) <= 1000.
 */
public class StringCompression {

    public static int solution(char[] chars) {
        int n = chars.length;
        int i = 0;
        int result = 0;
        
        while (i < n) {
            char c = chars[i];
            int count = 0;
            while (i < n && chars[i] == c) {
                i++;
                count++;
            }
            
            chars[result++] = c;
            if (count > 1) {
                for (char d : String.valueOf(count).toCharArray()) {
                    chars[result++] = d;
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(StringCompression.solution(chars));
        System.out.println(Arrays.toString(chars));
        
        char[] chars2 = {'a'};
        System.out.println(StringCompression.solution(chars2));
        System.out.println(Arrays.toString(chars2));
        
        char[] chars3 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(StringCompression.solution(chars3));
        System.out.println(Arrays.toString(chars3));
    }

}
