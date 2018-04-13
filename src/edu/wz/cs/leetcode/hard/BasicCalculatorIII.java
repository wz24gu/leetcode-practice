package edu.wz.cs.leetcode.hard;

import java.util.Stack;

/**
 * 772. Basic Calculator III<br>
 * https://leetcode.com/problems/basic-calculator-iii<br><br>
 * 
 * Implement a basic calculator to evaluate a simple expression string.<br>
 * 
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers 
 * and empty spaces .<br>
 * 
 * The expression string contains only non-negative integers, +, -, *, / operators , open ( and closing parentheses ) 
 * and empty spaces . The integer division should truncate toward zero.<br>
 * 
 * You may assume that the given expression is always valid. All intermediate results will be in the range of 
 * [-2147483648, 2147483647].<br>
 * 
 * Note: Do not use the eval built-in library function.
 */
public class BasicCalculatorIII {
    
    public static int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        
        int n = s.length();        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            
            if (c >= '0' && c <= '9') {
                int num = 0;
                while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                nums.push(num);
            }
            else if (c == '(') {
                ops.push('(');
            }
            else if (c == ')') {
                while (ops.peek() != '(') {
                    nums.push(eval(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.pop();
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!ops.isEmpty() && precedence(c, ops.peek())) {
                    nums.push(eval(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.push(c);
            }   
        }
        
        while (!ops.isEmpty()) {
            nums.push(eval(ops.pop(), nums.pop(), nums.pop()));
        }
        return nums.pop();
    }
    
    private static int eval(char op, int b, int a) {
        switch (op) {
        case '+': return a + b;
        case '-': return a - b;
        case '*': return a * b;
        case '/': return a / b;
        }
        return 0;
    }
    
    private static boolean precedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(BasicCalculatorIII.solution("1 + 1"));
        System.out.println(BasicCalculatorIII.solution(" 6-4 / 2 "));
        System.out.println(BasicCalculatorIII.solution("2*(5+5*2)/3+(6/2+8)"));
        System.out.println(BasicCalculatorIII.solution("(2+6* 3+5- (3*14/7+2)*5)+3"));
    }

}
