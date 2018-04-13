package edu.wz.cs.leetcode.hard;

import java.util.Stack;

/**
 * 32. Longest Valid Parentheses<br>
 * https://leetcode.com/problems/longest-valid-parentheses<br><br>
 * 
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) 
 * parentheses substring.<br>
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.<br>
 * 
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {
    
    public static int solution(String s) {
        int result = 0;
        int start = 0;        
        Stack<Integer> stack = new Stack<>();
        
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    start = i + 1;
                }
                else {
                    stack.pop();
                    result = stack.isEmpty() ? Math.max(result, i - start + 1) : Math.max(result, i - stack.peek());
                }
            }
        }
        
        return result;
    }

}
