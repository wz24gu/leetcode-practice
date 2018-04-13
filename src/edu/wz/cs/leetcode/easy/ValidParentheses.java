package edu.wz.cs.leetcode.easy;

import java.util.Stack;

/**
 * 20. Valid Parentheses<br>
 * https://leetcode.com/problems/valid-parentheses<br><br>
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.<br>
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    
    public static boolean solution(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
            else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
            else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
            else {
                stack.push(c);
            }
        }        
        
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        System.out.println(ValidParentheses.solution("{()}[]"));
        System.out.println(ValidParentheses.solution("{()}["));
    }

}
