package edu.wz.cs.leetcode.easy;

import java.util.Arrays;

/**
 * 806. Number of Lines To Write String<br>
 * https://leetcode.com/problems/number-of-lines-to-write-string<br><br>
 * 
 * We are to write the letters of a given string S, from left to right into lines. Each line has maximum width 100 units, 
 * and if writing a letter would cause the width of the line to exceed 100 units, it is written on the next line. We are 
 * given an array widths, an array where widths[0] is the width of 'a', widths[1] is the width of 'b', ..., and widths[25] 
 * is the width of 'z'.<br>
 * 
 * Now answer two questions: how many lines have at least one character from S, and what is the width used by the last 
 * such line? Return your answer as an integer list of length 2.<br><br>
 * 
 * Note:<br>
 * 1. The length of S will be in the range [1, 1000].<br>
 * 2. S will only contain lowercase letters.<br>
 * 3. widths is an array of length 26.<br>
 * 4. widths[i] will be in the range of [2, 10].
 */
public class NumberOfLinesToWriteString {
    
    public static int[] solution(int[] widths, String S) {
        int line = 1;
        int curr = 0;
        for (char c : S.toCharArray()) {
            int width = widths[c - 'a'];
            line = curr + width > 100 ? line + 1 : line;
            curr = curr + width > 100 ? width : curr + width;
        }
        return new int[] {line, curr};
    }
    
    public static void main(String[] args) {
        int[] widths = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        System.out.println(Arrays.toString(NumberOfLinesToWriteString.solution(widths, "abcdefghijklmnopqrstuvwxyz")));
        
        int[] widths2 = {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        System.out.println(Arrays.toString(NumberOfLinesToWriteString.solution(widths2, "bbbcccdddaaa")));
    }

}
