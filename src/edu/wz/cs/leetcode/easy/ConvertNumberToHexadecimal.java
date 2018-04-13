package edu.wz.cs.leetcode.easy;

/**
 * 405. Convert a Number to Hexadecimal<br>
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal<br><br>
 * 
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is 
 * used.<br><br>
 * 
 * Note:<br>
 * 1. All letters in hexadecimal (a-f) must be in lowercase.<br>
 * 2. The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single 
 * zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.<br>
 * 3. The given number is guaranteed to fit within the range of a 32-bit signed integer.<br>
 * 4. You must not use any method provided by the library which converts/formats the number to hex directly.
 */
public class ConvertNumberToHexadecimal {

    public static String solution(int num) {
        if (num == 0) {
            return "0";
        }
        
        String letter = "0123456789abcdef";
        
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int n = num & 0xf;  // 0b1111
            sb.insert(0, letter.charAt(n));
            num >>>= 4;
        }
        return sb.toString();   
    }
    
    public static void main(String[] args) {
        System.out.println(ConvertNumberToHexadecimal.solution(26));
        System.out.println(ConvertNumberToHexadecimal.solution(-1));
    }
    
}
