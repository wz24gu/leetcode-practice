package edu.wz.cs.leetcode.medium;

import java.util.Stack;

/**
 * 227. Basic Calculator II<br>
 * https://leetcode.com/problems/basic-calculator-ii<br><br>
 * 
 * Implement a basic calculator to evaluate a simple expression string.<br>
 * 
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer 
 * division should truncate toward zero.<br>
 * 
 * You may assume that the given expression is always valid.
 */
public class BasicCalculatorII {
    
    public static int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int n = s.length();
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = 0;
                while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
            }
            
            if ((s.charAt(i) < '0' || s.charAt(i) > '9') && s.charAt(i) != ' ' || i == n - 1) {
                if (sign == '+') {
                    stack.push(num);
                }
                else if (sign == '-') {
                    stack.push(-num);
                }
                else if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }            
        }
        
        int res = 0;
        for (int i : stack) {
            res += i;
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(BasicCalculatorII.solution("3+2*2"));
        System.out.println(BasicCalculatorII.solution(" 3/2 "));
        System.out.println(BasicCalculatorII.solution(" 3+5 / 2 "));
    }

}
