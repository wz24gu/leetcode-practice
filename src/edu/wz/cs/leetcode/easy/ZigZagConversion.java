package edu.wz.cs.leetcode.easy;

/**
 * 6. ZigZag Conversion<br/>
 * https://leetcode.com/problems/zigzag-conversion<br/><br/>
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to 
 * display this pattern in a fixed font for better legibility):<br/>
 * P   A   H   N<br/>
 * A P L S I I G<br/>
 * Y   I   R<br/>
 * And then read line by line: "PAHNAPLSIIGYIR"<br/>
 * 
 * Write the code that will take a string and make this conversion given a number of rows
 */
public class ZigZagConversion {

    public static String solution(String s, int row) {
        if (s == null || s.length() == 0 || row <= 0) {
            return "";
        }
        if (row == 1) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        int size = row * 2 - 2;
        for (int i = 0; i < row; i++) {
            for (int j = i; j < s.length(); j += size) {
                sb.append(s.charAt(j));
                if (i != 0 && i != row - 1) {  // except for the first and last line
                    int temp = j + size - i * 2;
                    if (temp < s.length()) {
                        sb.append(s.charAt(temp));
                    }
                }
                
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(ZigZagConversion.solution("PAYPALISHIRING", 3));
    }
}
