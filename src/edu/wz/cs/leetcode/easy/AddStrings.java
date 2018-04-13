package edu.wz.cs.leetcode.easy;

/**
 * 415. Add Strings<br>
 * https://leetcode.com/problems/add-strings<br><br>
 * 
 * Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.<br><br>
 * 
 * Note:<br>
 * 1. The length of both num1 and num2 is < 5100.<br>
 * 2. Both num1 and num2 contains only digits 0-9.<br>
 * 3. Both num1 and num2 does not contain any leading zero.<br>
 * 4. You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class AddStrings {
    
    public static String solution(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        
        while (i >= 0 || j >= 0) {
            int x = i < 0 ? 0 : num1.charAt(i--) - '0';
            int y = j < 0 ? 0 : num2.charAt(j--) - '0';
            sb.insert(0, (x + y + carry) % 10);
            carry = (x + y) / 10;
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(AddStrings.solution("999", "456"));
    }

}
