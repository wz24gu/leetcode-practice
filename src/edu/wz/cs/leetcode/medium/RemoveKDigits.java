package edu.wz.cs.leetcode.medium;

/**
 * 402. Remove K Digits<br>
 * https://leetcode.com/problems/remove-k-digits<br><br>
 * 
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is 
 * the smallest possible.<br><br>
 * 
 * Note:<br>
 * 1. The length of num is less than 10002 and will be >= k.<br>
 * 2. The given num does not contain any leading zero.
 */
public class RemoveKDigits {
    
    public static String solution(String num, int k) {
        int n = num.length();
        if (n == k) {
            return "0";
        }
        
        int digit = n - k;
        char[] stack = new char[n];
        int top = 0;
        
        for (char c : num.toCharArray()) {
            while (top > 0 && stack[top-1] > c && k > 0) {
                top--;
                k--;
            }
            stack[top++] = c;
        }
        
        int i = 0;
        while (i < digit && stack[i] == '0') {
            i++;
        }
        return new String(stack, i, digit - i);
    }
    
    public static void main(String[] args) {
        System.out.println(RemoveKDigits.solution("1432219", 3));
        System.out.println(RemoveKDigits.solution("10200", 1));
        System.out.println(RemoveKDigits.solution("10", 2));
        System.out.println(RemoveKDigits.solution("54321", 3));
    }
    
    

}
