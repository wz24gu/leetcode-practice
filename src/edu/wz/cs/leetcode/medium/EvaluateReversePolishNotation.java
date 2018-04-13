package edu.wz.cs.leetcode.medium;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation<br>
 * https://leetcode.com/problems/evaluate-reverse-polish-notation<br><br>
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.<br>
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 */
public class EvaluateReversePolishNotation {
    
    public static int solution(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String s = tokens[i];
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int y = stack.pop();
                int x = stack.pop();
                if (s.equals("+")) {
                    stack.push(x + y);
                }
                else if (s.equals("-")) {
                    stack.push(x - y);
                }
                else if (s.equals("*")) {
                    stack.push(x * y);
                }
                else if (s.equals("/")) {
                    stack.push(x / y);
                }
            }
            else {
                stack.push(Integer.parseInt(s));
            }            
        }
        
        return stack.pop();
    }
    
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(EvaluateReversePolishNotation.solution(tokens));
        
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println(EvaluateReversePolishNotation.solution(tokens2));
    }

}
