package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 43. Multiply Strings<br>
 * https://leetcode.com/problems/multiply-strings<br><br>
 * 
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.<br><br>
 * 
 * Note:<br>
 * 1. The length of both num1 and num2 is < 110.<br>
 * 2. Both num1 and num2 contains only digits 0-9.<br>
 * 3. Both num1 and num2 does not contain any leading zero.<br>
 * 4. You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings {
    
    public static String solution(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] tmp = new int[n1+n2];
        int k = n1 + n2 -2;
        
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                tmp[k-i-j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        System.out.println(Arrays.toString(tmp));
        
        int carry = 0;
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] += carry;
            carry = tmp[i] / 10;
            tmp[i] %= 10;
        }
        System.out.println(Arrays.toString(tmp));
        
        int i = tmp.length - 1;
        while (tmp[i] == 0) {
            i--;
        }
        if (i < 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            sb.append((char) (tmp[i] + '0'));
            i--;
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(MultiplyStrings.solution("88", "99"));
    }

}
