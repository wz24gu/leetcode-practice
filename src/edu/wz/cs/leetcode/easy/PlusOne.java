package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 66. Plus One<br>
 * https://leetcode.com/problems/plus-one<br><br>
 * 
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer. You may assume the 
 * integer do not contain any leading zero, except the number 0 itself. The digits are stored such that the most 
 * significant digit is at the head of the list.
 */
public class PlusOne {
    
    public static int[] solution(int[] digits) {
        List<Integer> list = new ArrayList<>();
        
        int n = digits.length;
        int sum = 0;
        int carry = 0;        
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                sum = digits[i] + 1;                
            }
            else {
                sum = digits[i] + carry;
            }
            carry = sum / 10;
            list.add(0, sum % 10);
        }
        if (carry > 0) {
            list.add(0, carry);
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    public static int[] solutionX(int[] digits) {        
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            else {
                digits[i] = 0;
            }
        }
        
        // if we reach here, all elements are 9
        int[] result = new int[n+1];
        result[0] = 1;
        return result;
    }
    
    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        System.out.println(Arrays.toString(PlusOne.solution(digits)));
        System.out.println(Arrays.toString(PlusOne.solutionX(digits)));
    }

}
