package edu.wz.cs.leetcode.medium;

import java.util.Stack;

/**
 * 224. Basic Calculator<br>
 * https://leetcode.com/problems/basic-calculator<br><br>
 * 
 * Implement a basic calculator to evaluate a simple expression string.<br>
 * 
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers 
 * and empty spaces.<br>
 * 
 * You may assume that the given expression is always valid.
 */
public class BasicCalculator {
    
    public static int solution(String s) {
        int n = s.length();
        int sign = 1;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int num = 0;
                while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                res += num * sign;
                i--;
            }
            else if (s.charAt(i) == '+') {
                sign = 1;
            }
            else if (s.charAt(i) == '-') {
                sign = -1;
            }
            else if (s.charAt(i) == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }
            else if (s.charAt(i) == ')') {
                res = res * stack.pop() + stack.pop();
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(BasicCalculator.solution("1 + 1"));
        System.out.println(BasicCalculator.solution(" 2-1 + 2 "));
        System.out.println(BasicCalculator.solution("(1+(4+5+2)-3)+(6+8)"));
    }

}
