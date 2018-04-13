package edu.wz.cs.leetcode.medium;

/**
 * 8. String to Integer (atoi)<br>
 * https://leetcode.com/problems/string-to-integer-atoi<br><br>
 * 
 * Implement atoi to convert a string to an integer.<br>
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself 
 * what are the possible input cases.<br>
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to 
 * gather all the input requirements up front.<br>
 * 
 * Update (2015-02-10):<br>
 * The signature of the C++ function had been updated. If you still see your function signature accepts a const char * 
 * argument, please click the reload button to reset your code definition.
 */
public class StringToInteger {
    
    public static int solution(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        int sign = 1;
        int n = str.length();    
        int i = 0;
        
        // get rid of leading space
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }
        // get the sign
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = (str.charAt(i) == '+') ? 1 : -1;
            i++;
        }
        
        // get digits
        long result = 0;
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (result >= Long.MAX_VALUE / 10) {
                return Integer.MAX_VALUE;
            }
            result = 10 * result + (str.charAt(i) - '0');
            i++;
        }
        
        // overflow?
        result = sign * result;        
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        else {
            return (int) result;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(StringToInteger.solution("0"));
        System.out.println(StringToInteger.solution("-1"));
        System.out.println(StringToInteger.solution("123"));
        System.out.println(StringToInteger.solution("9223372036854775809"));
    }

}
