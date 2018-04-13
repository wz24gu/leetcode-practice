package edu.wz.cs.leetcode.medium;

import java.util.Stack;

/**
 * 439. Ternary Expression Parser<br>
 * https://leetcode.com/problems/ternary-expression-parser<br><br>
 * 
 * Given a string representing arbitrarily nested ternary expressions, calculate the result of the expression. You can 
 * always assume that the given expression is valid and only consists of digits 0-9, ?, :, T and F (T and F represent 
 * True and False respectively).<br><br>
 * 
 * Note:<br>
 * 1. The length of the given string is <= 10000.<br>
 * 2. Each number will contain only one digit.<br>
 * 3. The conditional expressions group right-to-left (as usual in most languages).<br>
 * 4. The condition will always be either T or F. That is, the condition will never be a digit.<br>
 * 5. The result of the expression will always evaluate to either a digit 0-9, T or F.
 */
public class TernaryExpressionParser {
    
    public static String solution(String expression) {
        if (expression == null || expression.length() == 0) {
            return "";
        }
        
        Stack<Character> stack = new Stack<>();
        int n = expression.length();
        for (int i = n - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (c == ':') {
                continue;
            }
            else if (c == '?') {
                char next = expression.charAt(--i);
                if (next == 'T') {
                    char prev = stack.pop();
                    stack.pop();
                    stack.push(prev);
                }
                else {
                    stack.pop();
                }
            }
            else {
                stack.push(c);
            }
        }
        
        return String.valueOf(stack.pop());
    }
    
    public static void main(String[] args) {
        System.out.println(TernaryExpressionParser.solution("T?2:3"));
        System.out.println(TernaryExpressionParser.solution("F?1:T?4:5"));
        System.out.println(TernaryExpressionParser.solution("T?T?F:5:3"));
    }

}
